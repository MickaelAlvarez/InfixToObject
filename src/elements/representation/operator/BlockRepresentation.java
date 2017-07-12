package elements.representation.operator;

import elements.representation.IElementRepresentation;

public abstract class BlockRepresentation implements IElementRepresentation {
	
	@Override
	public boolean isOperator() {
		return true;
	}

	/**
	 * Sould not be called
	 */
	@Override
	public Double getDouble() {
		return null;
	}
}
