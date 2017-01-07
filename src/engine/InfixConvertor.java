package engine;

import elements.IEquation;
import engine.exception.WrongPrefixFormatError;

public class InfixConvertor implements Convertor<Integer> {
    private PrefixConvertor convertor;

    public InfixConvertor(PrefixConvertor convertor) {
        this.convertor = convertor;
    }

    public IEquation<Integer> convert(String equation) throws WrongPrefixFormatError {
        // TODO wrong infix format
        return convertor.convert(InfixToPrefix.convert(equation));
    }
}
