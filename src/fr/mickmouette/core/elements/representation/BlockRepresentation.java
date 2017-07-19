package fr.mickmouette.core.elements.representation;

import fr.mickmouette.core.elements.IElementBuilder;
import fr.mickmouette.core.elements.exception.BuildBlockOperatorException;
import fr.mickmouette.core.elements.exception.DontHaveAValueException;

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
	public IElementBuilder<T> getBuilder() throws BuildBlockOperatorException {
		throw new BuildBlockOperatorException();
	}
}
