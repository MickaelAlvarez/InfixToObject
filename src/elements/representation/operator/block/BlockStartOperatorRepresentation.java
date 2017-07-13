package elements.representation.operator.block;

public abstract class BlockStartOperatorRepresentation<T> extends BlockRepresentation<T> {
	@Override
	public boolean isBlockStart() {
		return true;
	}
	
	@Override
	public boolean isBlockEnd() {
		return false;
	}
}
