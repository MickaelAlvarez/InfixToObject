package elements.number;

public class NumberDouble implements INumber<Double> {
	private Double value;
	
	public NumberDouble(Double value) {
		this.value = value;
	}

	@Override
	public Double getValue() {
		return value;
	}

	@Override
	public Double add(INumber<Double> other) {
		return value + other.getValue();
	}

	@Override
	public Double multiply(INumber<Double> other) {
		return value * other.getValue();
	}

	@Override
	public Double substract(INumber<Double> other) {
		return value - other.getValue();
	}

	@Override
	public Double solve() {
	    return getValue();
	}

}
