package elements.representation.operator;

import elements.IEquation;
import elements.binaryOperator.BinaryOperator;
import elements.binaryOperator.Multiplier;
import elements.number.INumber;
import elements.number.factory.INumberFactory;

public class MultiplicationRepresentation<C, T extends INumber<C>> extends BinaryOperatorRepresentation<C, T> {

	@Override
	public int getPriority() {
		return 4;
	}

	@Override
	public BinaryOperator<C, T> build(IEquation<C> leftEq, IEquation<C> rightEq, INumberFactory<T, C> factory) {
		return new Multiplier<C, T>(leftEq, rightEq, factory);
	}

}
