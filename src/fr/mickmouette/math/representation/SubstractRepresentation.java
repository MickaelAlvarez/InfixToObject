package fr.mickmouette.math.representation;

import fr.mickmouette.core.elements.IEquation;
import fr.mickmouette.core.elements.generated.BinaryOperator;
import fr.mickmouette.core.elements.representation.BinaryOperatorRepresentation;
import fr.mickmouette.math.generated.Subtractor;

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
