package fr.mickmouette.core;

import java.util.ArrayList;

import fr.mickmouette.core.elements.IEquation;
import fr.mickmouette.core.elements.exception.convertion.ConvertionException;
import fr.mickmouette.core.elements.representation.IElementRepresentation;

public interface Convertor<T> {
    public IEquation<T> convert(ArrayList<IElementRepresentation<T>> equation) throws ConvertionException;
}
