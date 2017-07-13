package elements.representation.operator.block;

public class CloseParentheseRepresentation<T> extends BlockEndOperatorRepresentation<T> {

	@Override
	public int getPriority() {
		return 1;
	}

}
