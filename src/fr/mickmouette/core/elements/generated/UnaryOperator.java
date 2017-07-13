package fr.mickmouette.core.elements.generated;

import fr.mickmouette.core.elements.IEquation;

public abstract class UnaryOperator<C> implements IEquation<C> {
	protected C value;
	
	public UnaryOperator(C value) {
		this.value = value;
	}
	
}
