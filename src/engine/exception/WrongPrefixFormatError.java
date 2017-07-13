package engine.exception;

import java.util.ArrayList;

import elements.representation.IElementRepresentation;

public class WrongPrefixFormatError extends ConvertorException {
    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    public WrongPrefixFormatError(ArrayList<? extends IElementRepresentation<?>> equation) {
        super(equation);
    }

}
