package fr.mickmouette.core.engine;

import java.util.ArrayList;

import fr.mickmouette.core.Convertor;
import fr.mickmouette.core.elements.IEquation;
import fr.mickmouette.core.elements.exception.BuildException;
import fr.mickmouette.core.elements.representation.IElementRepresentation;
import fr.mickmouette.core.elements.representation.OperatorRepresentation;
import fr.mickmouette.core.engine.exception.ConvertorException;
import fr.mickmouette.core.engine.exception.WrongPrefixFormatError;

public class PrefixToObject<T> implements Convertor<T> {

	public PrefixToObject() {

	}

	@Override
	public IEquation<T> convert(ArrayList<IElementRepresentation<T>> equation) throws ConvertorException, BuildException {
		// TODO Exception
		return equation.get(0).convert(new ArrayList<>(equation.subList(1, equation.size())));
	}

}
