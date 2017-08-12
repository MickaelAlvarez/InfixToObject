package fr.mickmouette.core.elements.representation;

import java.util.ArrayList;

import fr.mickmouette.core.elements.IEquation;
import fr.mickmouette.core.elements.exception.DontHaveAValueException;
import fr.mickmouette.core.elements.exception.convertion.ConvertionException;
import fr.mickmouette.core.elements.exception.convertion.ConvertBlockRepresentationOperatorException;

public abstract class BlockRepresentation<T> implements IElementRepresentation<T> {
	
	@Override
	public boolean isOperator() {
		return true;
	}

	@Override
	public T getValue() throws DontHaveAValueException {
		throw new DontHaveAValueException();
	}
	
	@Override
	public IEquation<T> convert(ArrayList<IElementRepresentation<T>> equation) throws ConvertionException {
		throw new ConvertBlockRepresentationOperatorException();
	}
}
