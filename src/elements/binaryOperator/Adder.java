package elements.binaryOperator;

import elements.IEquation;

public class Adder extends BinaryOperator<Double> {

	public Adder(IEquation<Double> leftOperand, IEquation<Double> rightOperand) {
		super(leftOperand, rightOperand);
	}

	@Override
	public Double apply() {
		return leftOperand.apply() + rightOperand.apply();
	}

}
