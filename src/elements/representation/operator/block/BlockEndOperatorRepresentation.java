package elements.representation.operator.block;

public abstract class BlockEndOperatorRepresentation<T> extends BlockRepresentation<T> {
	@Override
	public boolean isBlockStart() {
		return false;
	}
	
	@Override
	public boolean isBlockEnd() {
		return true;
	}
}
