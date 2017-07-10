package elements.representation.operator;

import elements.number.INumber;

public abstract class BinaryOperatorRepresentation<C, T extends INumber<C>> extends OperatorRepresentation<C, T> {
	@Override
	public boolean isBlockStart() {
		return false;
	}
	
	@Override
	public boolean isBlockEnd() {
		return false;
	}
}
