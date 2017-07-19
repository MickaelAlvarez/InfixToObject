package fr.mickmouette.core;

import java.util.ArrayList;

import fr.mickmouette.core.elements.IEquation;
import fr.mickmouette.core.elements.exception.BuildException;
import fr.mickmouette.core.elements.representation.IElementRepresentation;
import fr.mickmouette.core.engine.exception.ConvertorException;

public interface Convertor<T> {
    public IEquation<T> convert(ArrayList<IElementRepresentation<T>> equation) throws ConvertorException, BuildException;
}
