package elements.representation.operator;

public class SubstractRepresentation extends OperatorRepresentation {

	@Override
	public Type getType() {
		return Type.SUBSTRACTION;
	}

	@Override
	public int getPriority() {
		return 2;
	}

}
