package elements.representation.operator;

public class AdditionRepresentation extends OperatorRepresentation {

	@Override
	public Type getType() {
		return Type.ADDITION;
	}

	@Override
	public int getPriority() {
		return 2;
	}

}