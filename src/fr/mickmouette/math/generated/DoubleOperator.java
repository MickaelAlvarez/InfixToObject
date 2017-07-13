package fr.mickmouette.math.generated;

import fr.mickmouette.core.elements.generated.UnaryOperator;

public class DoubleOperator extends UnaryOperator<Double> {

	public DoubleOperator(Double value) {
		super(value);
	}

	@Override
	public Double apply() {
		return value;
	}
	
}
