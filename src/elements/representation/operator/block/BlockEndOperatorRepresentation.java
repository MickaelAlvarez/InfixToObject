package elements.representation.operator.block;

import elements.representation.operator.BlockRepresentation;

public abstract class BlockEndOperatorRepresentation extends BlockRepresentation{
	@Override
	public boolean isBlockStart() {
		return false;
	}
	
	@Override
	public boolean isBlockEnd() {
		return true;
	}
}
