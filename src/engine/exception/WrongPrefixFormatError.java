package engine.exception;

import java.util.ArrayList;

import elements.representation.IElementRepresentation;

public class WrongPrefixFormatError extends ConvertorException {
    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    public WrongPrefixFormatError(ArrayList<IElementRepresentation> equation) {
        super(equation);
    }

}
