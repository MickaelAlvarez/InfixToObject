package fr.mickmouette.core.elements.representation;

import fr.mickmouette.core.elements.IEquation;
import fr.mickmouette.core.elements.generated.BinaryOperator;

public abstract class OperatorRepresentation<T> implements IElementRepresentation<T> {

	public abstract BinaryOperator<T> build(IEquation<T> leftEq, IEquation<T> rightEq);
	
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
