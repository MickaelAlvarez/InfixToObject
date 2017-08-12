package fr.mickmouette.core.elements.representation;


import java.util.ArrayList;

import fr.mickmouette.core.elements.IEquation;
import fr.mickmouette.core.elements.exception.convertion.ConvertionException;
import fr.mickmouette.core.elements.exception.convertion.ConvertBinaryOperatorException;
import fr.mickmouette.core.elements.generated.BinaryOperator;

public abstract class BinaryOperatorRepresentation<T> extends OperatorRepresentation<T> {
	protected abstract BinaryOperator<T> build(IEquation<T> leftEq, IEquation<T> rightEq);
	
	@Override
	public boolean isBlockStart() {
		return false;
	}
	
	@Override
	public boolean isBlockEnd() {
		return false;
	}
	
	@Override
	public IEquation<T> convert(ArrayList<IElementRepresentation<T>> equation) throws ConvertionException {
		if(equation == null || equation.size() < 2) {
			throw new ConvertBinaryOperatorException();
		}
		
		int rightOperandStartIndex = getRightOperandStartIndex(equation);
		ArrayList<IElementRepresentation<T>> leftEquationRepresentation = new ArrayList<>(equation.subList(0, rightOperandStartIndex));
		ArrayList<IElementRepresentation<T>> rightEquationRepresentation = new ArrayList<>(equation.subList(rightOperandStartIndex, equation.size()));
		
		IEquation<T> leftEquation = leftEquationRepresentation.get(0).convert(new ArrayList<>(leftEquationRepresentation.subList(1, leftEquationRepresentation.size())));
		IEquation<T> rightEquation = rightEquationRepresentation.get(0).convert(new ArrayList<>(rightEquationRepresentation.subList(1, rightEquationRepresentation.size())));
		
		return build(leftEquation, rightEquation);
	}
	
	private int getRightOperandStartIndex(ArrayList<IElementRepresentation<T>> equation) {
		int index = 0, numberNeeded = 0;
		
		if(!equation.get(0).isOperator()) {
			return 1;
		} else {
			numberNeeded = 1;
			while(numberNeeded > 0) {
				if(equation.get(index).isOperator()) {
					numberNeeded ++;
				} else {
					numberNeeded --;
				}
				index++;
			}
		}
		
		return index;
	}
}
