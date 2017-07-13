package elements.representation.operator.block;

import elements.representation.IElementRepresentation;

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
