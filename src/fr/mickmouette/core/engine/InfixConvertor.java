package fr.mickmouette.core.engine;

import java.util.ArrayList;

import fr.mickmouette.core.Convertor;
import fr.mickmouette.core.elements.IEquation;
import fr.mickmouette.core.elements.exception.BuildException;
import fr.mickmouette.core.elements.representation.IElementRepresentation;
import fr.mickmouette.core.engine.exception.ConvertorException;

/**
 * Transform an infixed formatted list of IElementRepresentation into an IEquation
 * 
 * @author Mickael Alvarez
 *
 * @param <V> the applied return type
 */
public class InfixConvertor<V> implements Convertor<V> {
    private PrefixToObject<V> convertor;

    public InfixConvertor(PrefixToObject<V> convertor) {
        this.convertor = convertor;
    }

    public IEquation<V> convert(ArrayList<IElementRepresentation<V>> equation) throws ConvertorException, BuildException {
        // TODO wrong infix format
        return convertor.convert(new InfixToPrefix<V>().convert(equation));
    }

}