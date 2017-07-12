package elements.representation.operator;

import elements.IEquation;
import elements.binaryOperator.BinaryOperator;

public class DivisionRepresentation extends BinaryOperatorRepresentation<Double> {

	@Override
	public int getPriority() {
		return 4;
	}

	@Override
	public BinaryOperator<Double> build(IEquation<Double> leftEq, IEquation<Double> rightEq) {
		// TODO Auto-generated method stub
		return null;
	}

}
