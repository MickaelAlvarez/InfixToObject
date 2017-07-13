package engine;

import java.util.ArrayList;

import elements.IEquation;
import elements.representation.IElementRepresentation;
import elements.representation.number.NumberRepresentation;
import elements.representation.operator.OperatorRepresentation;
import engine.exception.ConvertorException;
import engine.exception.WrongPrefixFormatError;

public class PrefixToObject<T> implements Convertor<T> {

	public PrefixToObject() {

	}

	@Override
	public IEquation<T> convert(ArrayList<IElementRepresentation<T>> equation) throws ConvertorException {
		if (equation.get(0).isOperator()) {
			int rightOperandStartIndex = getRightOperandStartIndex(equation);
			OperatorRepresentation<T> operator = (OperatorRepresentation<T>) equation.get(0);
			return operator.build(convert(new ArrayList<>(equation.subList(1, rightOperandStartIndex))), convert(new ArrayList<>(equation.subList(rightOperandStartIndex, equation.size()))));
		} else {
			if (equation.size() == 1) {
				return ((NumberRepresentation<T>)equation.get(0)).build();
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
