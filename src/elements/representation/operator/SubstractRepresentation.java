package elements.representation.operator;

import elements.IEquation;
import elements.binaryOperator.BinaryOperator;
import elements.binaryOperator.Subtractor;

public class SubstractRepresentation extends BinaryOperatorRepresentation<Double> {

	@Override
	public int getPriority() {
		return 2;
	}

	@Override
	public BinaryOperator<Double> build(IEquation<Double> leftEq, IEquation<Double> rightEq) {
		return new Subtractor(leftEq, rightEq);
	}

}
