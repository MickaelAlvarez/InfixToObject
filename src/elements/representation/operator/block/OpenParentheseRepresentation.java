package elements.representation.operator.block;

public class OpenParentheseRepresentation<T> extends BlockStartOperatorRepresentation<T> {

	@Override
	public int getPriority() {
		return 1;
	}

}
