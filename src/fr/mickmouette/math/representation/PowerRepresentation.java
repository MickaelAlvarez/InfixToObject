package fr.mickmouette.math.representation;

import fr.mickmouette.core.elements.IEquation;
import fr.mickmouette.core.elements.generated.BinaryOperator;
import fr.mickmouette.core.elements.representation.BinaryOperatorRepresentation;

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