package fr.mickmouette.core.engine;

import java.util.ArrayList;

import fr.mickmouette.core.Convertor;
import fr.mickmouette.core.elements.IEquation;
import fr.mickmouette.core.elements.representation.IElementRepresentation;
import fr.mickmouette.core.engine.exception.ConvertorException;

public class InfixConvertor<V> implements Convertor<V> {
    private PrefixToObject<V> convertor;

    public InfixConvertor(PrefixToObject<V> convertor) {
        this.convertor = convertor;
    }

    public IEquation<V> convert(ArrayList<IElementRepresentation<V>> equation) throws ConvertorException {
        // TODO wrong infix format
        return convertor.convert(new InfixToPrefix<V>().convert(equation));
    }

}
