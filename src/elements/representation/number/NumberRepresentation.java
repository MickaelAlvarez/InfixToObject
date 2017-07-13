package elements.representation.number;

import elements.number.UnaryOperator;
import elements.representation.IElementRepresentation;

public abstract class NumberRepresentation<T> implements IElementRepresentation<T> {
	protected T value;
	public abstract UnaryOperator<T> build();

	public NumberRepresentation(T value) {
		this.value = value;
	}
	
	@Override
	public boolean isOperator() {
		return false;
	}
	
	@Override
	public boolean isBlockStart() {
		return false;
	}
	
	@Override
	public boolean isBlockEnd() {
		return false;
	}

	@Override
	public int getPriority() {
		return 0;
	}
}
