package elements.representation;

public interface IElementRepresentation {
	public enum Type {
		ADDITION, SUBSTRACTION, MULTIPLICATION, DIVISION, POWER, OPEN_PARENTHESE, CLOSE_PARENTHESE, DOUBLE
	}
	public boolean isOperator();
	public Type getType();
	public Double getDouble();
	public int getPriority();
}
