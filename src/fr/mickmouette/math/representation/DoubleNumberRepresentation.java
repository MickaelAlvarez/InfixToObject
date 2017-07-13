package fr.mickmouette.math.representation;

import fr.mickmouette.core.elements.generated.UnaryOperator;
import fr.mickmouette.core.elements.representation.NumberRepresentation;
import fr.mickmouette.math.generated.DoubleOperator;

public class DoubleNumberRepresentation extends NumberRepresentation<Double> {
	

	public DoubleNumberRepresentation(Double value) {
		super(value);
	}

	@Override
	public Double getValue() {
		return value;
	}

	@Override
	public UnaryOperator<Double> build() {
		return new DoubleOperator(value);
	}

}
