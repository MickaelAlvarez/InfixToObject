package elements.representation.operator;

import elements.representation.IElementRepresentation;

public abstract class OperatorRepresentation implements IElementRepresentation {

	@Override
	public boolean isOperator() {
		return true;
	}

	@Override
	public Double getDouble() {
		return null;
	}
}
