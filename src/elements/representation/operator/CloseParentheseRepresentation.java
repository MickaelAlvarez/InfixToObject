package elements.representation.operator;

import elements.representation.operator.block.BlockEndOperatorRepresentation;

public class CloseParentheseRepresentation extends BlockEndOperatorRepresentation {

	@Override
	public int getPriority() {
		return 1;
	}

}
