package engine;

import java.util.ArrayList;

import elements.IEquation;
import elements.binaryOperator.Adder;
import elements.number.NumberDouble;
import elements.number.factory.NumberDoubleFactory;
import elements.representation.IElementRepresentation;
import elements.representation.IElementRepresentation.Type;
import elements.representation.number.DoubleNumberRepresentation;
import engine.exception.WrongPrefixFormatError;

public class PrefixConvertor implements Convertor<Double> {

	public PrefixConvertor() {

	}

	@Override
	public IEquation<Double> convert(ArrayList<IElementRepresentation> equation) throws WrongPrefixFormatError {
		if (equation.get(0).isOperator()) {
			int rightOperandStartIndex = getRightOperandStartIndex(equation);
			return new Adder<Double, NumberDouble>(convert(new ArrayList<>(equation.subList(1, rightOperandStartIndex))), convert(new ArrayList<>(equation.subList(rightOperandStartIndex, equation.size()))), new NumberDoubleFactory());
		} else {
			if (equation.size() == 1) {
				if (equation.get(0).getType().equals(Type.DOUBLE)) {
					return new NumberDouble(((DoubleNumberRepresentation) equation.get(0)).getDouble());
				}
			} else {
				 throw new WrongPrefixFormatError(equation);
			}
		}

		return null;
	}

	private int getRightOperandStartIndex(ArrayList<IElementRepresentation> equation) {
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
