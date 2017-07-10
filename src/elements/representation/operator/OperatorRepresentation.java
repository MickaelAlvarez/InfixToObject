package elements.representation.operator;

import elements.IEquation;
import elements.binaryOperator.BinaryOperator;
import elements.number.INumber;
import elements.number.factory.INumberFactory;
import elements.representation.IElementRepresentation;

public abstract class OperatorRepresentation<C, T extends INumber<C>> implements IElementRepresentation {

	public abstract BinaryOperator<C, T> build(IEquation<C> leftEq, IEquation<C> rightEq, INumberFactory<T, C> factory);
	
	@Override
	public boolean isOperator() {
		return true;
	}

	@Override
	public Double getDouble() {
		return null;
	}
	
	
}
