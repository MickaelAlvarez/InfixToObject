package elements.number;

public class NumberInteger implements INumber<Integer> {
	private Integer value;

	public NumberInteger(Integer value) {
		this.value = value;
	}

	@Override
	public Integer getValue() {
		return value;
	}

	@Override
	public Integer add(INumber<Integer> other) {
		return value + other.getValue();
	}

	@Override
	public Integer multiply(INumber<Integer> other) {
		return value * other.getValue();
	}

	@Override
	public Integer substract(INumber<Integer> other) {
		return value - other.getValue();
	}

}
