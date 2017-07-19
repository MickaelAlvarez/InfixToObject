package fr.mickmouette.core.elements.generated;

import fr.mickmouette.core.elements.IEquation;

public abstract class UnaryOperator<C> implements IEquation<C> {
	protected IEquation<C> operand;
	
	public UnaryOperator(IEquation<C> operand) {
		this.operand = operand;
	}
}
