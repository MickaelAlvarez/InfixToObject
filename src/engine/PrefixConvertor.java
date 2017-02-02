package engine;

import java.util.ArrayList;

import elements.IEquation;
import elements.binaryOperator.Adder;
import elements.number.INumber;
import elements.number.NumberDouble;
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
			return new Adder<Double, INumber<Double>>(new NumberDouble(1d), new NumberDouble(1d));
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

}
