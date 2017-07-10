package elements.representation;

public interface IElementRepresentation {
	public boolean isOperator();
	public boolean isBlockStart();
	public boolean isBlockEnd();
	public Double getDouble();
	public int getPriority();
}
