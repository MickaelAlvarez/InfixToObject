package elements.binaryOperator;

import elements.IEquation;

public class Multiplier extends BinaryOperator<Double> {

	public Multiplier(IEquation<Double> leftOperand, IEquation<Double> rightOperand) {
		super(leftOperand, rightOperand);
	}

	@Override
	public Double apply() {
		return leftOperand.apply() * rightOperand.apply();
	}

}
