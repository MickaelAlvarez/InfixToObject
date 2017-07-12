package elements.representation.operator;

import elements.IEquation;
import elements.binaryOperator.BinaryOperator;
import elements.representation.IElementRepresentation;

public abstract class OperatorRepresentation<T> implements IElementRepresentation {

	public abstract BinaryOperator<T> build(IEquation<T> leftEq, IEquation<T> rightEq);
	
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
