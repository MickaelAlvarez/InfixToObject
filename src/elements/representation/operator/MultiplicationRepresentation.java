package elements.representation.operator;

import elements.IEquation;
import elements.binaryOperator.BinaryOperator;
import elements.binaryOperator.Multiplier;

public class MultiplicationRepresentation extends BinaryOperatorRepresentation<Double> {

	@Override
	public int getPriority() {
		return 4;
	}

	@Override
	public BinaryOperator<Double> build(IEquation<Double> leftEq, IEquation<Double> rightEq) {
		return new Multiplier(leftEq, rightEq);
	}

}
