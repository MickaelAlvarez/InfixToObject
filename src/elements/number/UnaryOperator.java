package elements.number;

import elements.IEquation;

public abstract class UnaryOperator<C> implements IEquation<C> {
	protected C value;
	
	public UnaryOperator(C value) {
		this.value = value;
	}
	
}
