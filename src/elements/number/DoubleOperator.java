package elements.number;

public class DoubleOperator extends UnaryOperator<Double> {

	public DoubleOperator(Double value) {
		super(value);
	}

	@Override
	public Double apply() {
		return value;
	}
	
}
