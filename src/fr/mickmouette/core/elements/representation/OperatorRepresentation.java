package fr.mickmouette.core.elements.representation;

import fr.mickmouette.core.elements.exception.DontHaveAValueException;

public abstract class OperatorRepresentation<T> implements IElementRepresentation<T> {

	@Override
	public boolean isOperator() {
		return true;
	}

	@Override
	public T getValue() throws DontHaveAValueException {
		throw new DontHaveAValueException();
	}
	
	
}
