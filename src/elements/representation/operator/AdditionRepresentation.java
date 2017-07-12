package elements.representation.operator;

import elements.IEquation;
import elements.binaryOperator.Adder;
import elements.binaryOperator.BinaryOperator;

public class AdditionRepresentation extends BinaryOperatorRepresentation<Double> {

	@Override
	public int getPriority() {
		return 2;
	}

	@Override
	public BinaryOperator<Double> build(IEquation<Double> leftEq, IEquation<Double> rightEq) {
		return new Adder(leftEq, rightEq);
	}

}
