package fr.mickmouette.core.engine;

import java.util.ArrayList;

import fr.mickmouette.core.Convertor;
import fr.mickmouette.core.elements.IEquation;
import fr.mickmouette.core.elements.exception.convertion.ConvertionException;
import fr.mickmouette.core.elements.representation.IElementRepresentation;

public class PrefixToObject<T> implements Convertor<T> {

	public PrefixToObject() {

	}

	@Override
	public IEquation<T> convert(ArrayList<IElementRepresentation<T>> equation) throws ConvertionException {
		return equation.get(0).convert(new ArrayList<>(equation.subList(1, equation.size())));
	}

}
