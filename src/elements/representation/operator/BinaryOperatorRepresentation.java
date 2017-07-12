package elements.representation.operator;

public abstract class BinaryOperatorRepresentation<T> extends OperatorRepresentation<T> {
	@Override
	public boolean isBlockStart() {
		return false;
	}
	
	@Override
	public boolean isBlockEnd() {
		return false;
	}
}
