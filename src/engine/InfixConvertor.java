package engine;

import java.util.ArrayList;

import elements.IEquation;
import elements.representation.IElementRepresentation;
import engine.exception.WrongPrefixFormatError;

public class InfixConvertor implements Convertor<Double> {
    private PrefixConvertor convertor;

    public InfixConvertor(PrefixConvertor convertor) {
        this.convertor = convertor;
    }

    public IEquation<Double> convert(ArrayList<IElementRepresentation> equation) throws WrongPrefixFormatError {
        // TODO wrong infix format
        return convertor.convert(InfixToPrefix.convert(equation));
    }
}
