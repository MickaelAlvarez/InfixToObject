package elements.representation.operator;

public class CloseParentheseRepresentation extends OperatorRepresentation {

	@Override
	public Type getType() {
		return Type.CLOSE_PARENTHESE;
	}

	@Override
	public int getPriority() {
		return 1;
	}

}