package fr.mickmouette.math.generated;

import fr.mickmouette.core.elements.generated.ValueOperator;

public class DoubleOperator extends ValueOperator<Double> {

	public DoubleOperator(Double value) {
		super(value);
	}

	@Override
	public Double apply() {
		return value;
	}
	
}
