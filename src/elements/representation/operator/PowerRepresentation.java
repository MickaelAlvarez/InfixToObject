package elements.representation.operator;

import elements.IEquation;
import elements.binaryOperator.BinaryOperator;

public class PowerRepresentation extends BinaryOperatorRepresentation<Double> {

	@Override
	public int getPriority() {
		return 6;
	}

	@Override
	public BinaryOperator<Double> build(IEquation<Double> leftEq, IEquation<Double> rightEq) {
		// TODO Auto-generated method stub
		return null;
	}

}
