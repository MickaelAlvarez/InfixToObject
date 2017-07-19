package fr.mickmouette.core.elements.generated;

import fr.mickmouette.core.elements.IEquation;

public abstract class ValueOperator<C> implements IEquation<C> {
	protected C value;
	
	public ValueOperator(C value) {
		this.value = value;
	}
	
}
