package fr.mickmouette.core.elements.representation;

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
