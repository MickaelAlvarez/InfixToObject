package elements.representation.operator;

import elements.representation.operator.block.BlockStartOperatorRepresentation;

public class OpenParentheseRepresentation extends BlockStartOperatorRepresentation {

	@Override
	public int getPriority() {
		return 1;
	}

}
