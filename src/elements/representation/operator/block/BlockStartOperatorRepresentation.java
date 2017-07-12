package elements.representation.operator.block;

import elements.representation.operator.BlockRepresentation;

public abstract class BlockStartOperatorRepresentation extends BlockRepresentation {
	@Override
	public boolean isBlockStart() {
		return true;
	}
	
	@Override
	public boolean isBlockEnd() {
		return false;
	}
}
