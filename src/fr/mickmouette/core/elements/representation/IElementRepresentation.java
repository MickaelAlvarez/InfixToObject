package fr.mickmouette.core.elements.representation;

public interface IElementRepresentation<V> {
	public boolean isOperator();
	public boolean isBlockStart();
	public boolean isBlockEnd();
	public V getValue();
	public int getPriority();
}
