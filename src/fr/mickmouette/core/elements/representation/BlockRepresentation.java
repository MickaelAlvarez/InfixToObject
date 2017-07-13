package fr.mickmouette.core.elements.representation;

public abstract class BlockRepresentation<T> implements IElementRepresentation<T> {
	
	@Override
	public boolean isOperator() {
		return true;
	}

	/**
	 * Sould not be called
	 */
	@Override
	public T getValue() {
		return null;
	}
}
