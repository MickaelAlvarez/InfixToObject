package elements.representation.operator;

public class DivisionRepresentation extends OperatorRepresentation {

	@Override
	public Type getType() {
		return Type.DIVISION;
	}

	@Override
	public int getPriority() {
		return 4;
	}

}
