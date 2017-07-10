package elements.representation.number;

public class DoubleNumberRepresentation extends NumberRepresentation {
	private Double value;
	
	public DoubleNumberRepresentation(double value) {
		this.value = value;
	}

	@Override
	public Double getDouble() {
		return value;
	}

}
