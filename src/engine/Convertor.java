package engine;

import elements.IEquation;
import engine.exception.ConvertorException;

public interface Convertor<T> {
    public IEquation<T> convert(String equation) throws ConvertorException;
}
