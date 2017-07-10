package elements.representation.operator.block;

import elements.number.INumber;
import elements.representation.operator.BinaryOperatorRepresentation;
import elements.representation.operator.OperatorRepresentation;

public abstract class BlockEndOperatorRepresentation<C, T extends INumber<C>> extends BinaryOperatorRepresentation<C, T>{
	@Override
	public boolean isBlockStart() {
		return false;
	}
	
	@Override
	public boolean isBlockEnd() {
		return true;
	}
}
