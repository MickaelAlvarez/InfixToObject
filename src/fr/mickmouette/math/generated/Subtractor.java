package fr.mickmouette.math.generated;

import fr.mickmouette.core.elements.IEquation;
import fr.mickmouette.core.elements.generated.BinaryOperator;

public class Subtractor extends BinaryOperator<Double> {
	
	public Subtractor(IEquation<Double> leftOperand, IEquation<Double> rightOperand) {
		super(leftOperand, rightOperand);
	}

	@Override
	public Double apply() {
		return leftOperand.apply() - rightOperand.apply();
	}

}
