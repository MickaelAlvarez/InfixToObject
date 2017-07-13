package engine;

import java.util.ArrayList;

import elements.IEquation;
import elements.representation.IElementRepresentation;
import engine.exception.ConvertorException;

public interface Convertor<T> {
    public IEquation<T> convert(ArrayList<IElementRepresentation<T>> equation) throws ConvertorException;
}
