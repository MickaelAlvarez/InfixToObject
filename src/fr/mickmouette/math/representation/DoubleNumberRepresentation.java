package fr.mickmouette.math.representation;

import fr.mickmouette.core.elements.generated.ValueOperator;
import fr.mickmouette.core.elements.representation.ValueOperatorRepresentation;
import fr.mickmouette.math.generated.DoubleOperator;

public class DoubleNumberRepresentation extends ValueOperatorRepresentation<Double> {
	

	public DoubleNumberRepresentation(Double value) {
		super(value);
	}

	@Override
	public Double getValue() {
		return value;
	}

	@Override
	public ValueOperator<Double> build() {
		return new DoubleOperator(value);
	}

}
