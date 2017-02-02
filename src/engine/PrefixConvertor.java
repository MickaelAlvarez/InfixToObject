package engine;

import java.util.ArrayList;

import elements.IEquation;
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

        } else {
            if (equation.get(0).getType().equals(Type.DOUBLE)) {
                return new NumberDouble(((DoubleNumberRepresentation) equation.get(0)).getDouble());
            } else {
//                throw new WrongPrefixFormatError(equation);
            	// TODO
            }
        }

        return null;
    }

}
