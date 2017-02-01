package elements.representation.operator;

public class OpenParentheseRepresentation extends OperatorRepresentation {

	@Override
	public Type getType() {
		return Type.OPEN_PARENTHESE;
	}

	@Override
	public int getPriority() {
		return 1;
	}

}
