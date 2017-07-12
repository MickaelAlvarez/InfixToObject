package elements.representation.number;

import elements.number.DoubleOperator;
import elements.number.UnaryOperator;

public class DoubleNumberRepresentation extends NumberRepresentation<Double> {
	

	public DoubleNumberRepresentation(Double value) {
		super(value);
	}

	@Override
	public Double getDouble() {
		return value;
	}

	@Override
	public UnaryOperator<Double> build() {
		return new DoubleOperator(value);
	}

}
