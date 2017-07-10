package elements.representation.operator.block;

import elements.number.INumber;
import elements.representation.operator.OperatorRepresentation;

public abstract class BlockStartOperatorRepresentation<C, T extends INumber<C>> extends OperatorRepresentation<C, T> {
	@Override
	public boolean isBlockStart() {
		return true;
	}
	
	@Override
	public boolean isBlockEnd() {
		return false;
	}
}
