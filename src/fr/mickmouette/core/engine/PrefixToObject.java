package fr.mickmouette.core.engine;

import java.util.ArrayList;

import fr.mickmouette.core.Convertor;
import fr.mickmouette.core.elements.IEquation;
import fr.mickmouette.core.elements.exception.BuildException;
import fr.mickmouette.core.elements.representation.IElementRepresentation;
import fr.mickmouette.core.elements.representation.OperatorRepresentation;
import fr.mickmouette.core.engine.exception.ConvertorException;
import fr.mickmouette.core.engine.exception.WrongPrefixFormatError;

public class PrefixToObject<T> implements Convertor<T> {

	public PrefixToObject() {

	}

	@Override
	public IEquation<T> convert(ArrayList<IElementRepresentation<T>> equation) throws ConvertorException, BuildException {
		if (equation.get(0).isOperator()) {
			int rightOperandStartIndex = getRightOperandStartIndex(equation);
			OperatorRepresentation<T> operator = (OperatorRepresentation<T>) equation.get(0);
			return operator.getBuilder().buildBinaryOperator(convert(new ArrayList<>(equation.subList(1, rightOperandStartIndex))), convert(new ArrayList<>(equation.subList(rightOperandStartIndex, equation.size()))));
		} else {
			if (equation.size() == 1) {
				return equation.get(0).getBuilder().buildValueOperator();
			} else {
				throw new WrongPrefixFormatError(equation);
			}
		}
	}

	private int getRightOperandStartIndex(ArrayList<IElementRepresentation<T>> equation) {
		int index = 0, numberNeeded = 0;
		
		if(!equation.get(1).isOperator()) {
			return 2;
		} else {
			numberNeeded = 2;
			index = 2;
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
