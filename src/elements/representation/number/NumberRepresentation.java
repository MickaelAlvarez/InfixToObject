package elements.representation.number;

import elements.representation.IElementRepresentation;

public abstract class NumberRepresentation implements IElementRepresentation {

	@Override
	public boolean isOperator() {
		return false;
	}

}
