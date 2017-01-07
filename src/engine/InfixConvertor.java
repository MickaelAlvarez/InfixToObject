package engine;

import elements.IEquation;
import engine.exception.WrongPrefixFormatError;

public class InfixConvertor implements Convertor<Double> {
    private PrefixConvertor convertor;

    public InfixConvertor(PrefixConvertor convertor) {
        this.convertor = convertor;
    }

    public IEquation<Double> convert(String equation) throws WrongPrefixFormatError {
        // TODO wrong infix format
        return convertor.convert(InfixToPrefix.convert(equation));
    }
}
