package elements.binaryOperator;

import elements.IEquation;

public class Subtractor extends BinaryOperator<Double> {
	
	public Subtractor(IEquation<Double> leftOperand, IEquation<Double> rightOperand) {
		super(leftOperand, rightOperand);
	}

	@Override
	public Double apply() {
		return leftOperand.apply() - rightOperand.apply();
	}

}
