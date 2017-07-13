package engine.exception;

import java.util.ArrayList;

import elements.representation.IElementRepresentation;

public class ConvertorException extends Exception {
    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    public ConvertorException(ArrayList<? extends IElementRepresentation<?>> equation) {
        super();
    }
}
