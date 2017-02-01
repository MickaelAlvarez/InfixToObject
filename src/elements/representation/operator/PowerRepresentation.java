package elements.representation.operator;

public class PowerRepresentation extends OperatorRepresentation {

	@Override
	public Type getType() {
		return Type.POWER;
	}

	@Override
	public int getPriority() {
		return 6;
	}

}
