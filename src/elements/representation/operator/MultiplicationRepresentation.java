package elements.representation.operator;

public class MultiplicationRepresentation extends OperatorRepresentation {

	@Override
	public Type getType() {
		return Type.MULTIPLICATION;
	}

	@Override
	public int getPriority() {
		return 4;
	}

}
