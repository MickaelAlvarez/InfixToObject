package fr.mickmouette.core.elements.representation;

import fr.mickmouette.core.elements.IElementBuilder;
import fr.mickmouette.core.elements.exception.BuildBlockOperatorException;
import fr.mickmouette.core.elements.exception.DontHaveAValueException;

public interface IElementRepresentation<V> {
	public boolean isOperator();
	public boolean isBlockStart();
	public boolean isBlockEnd();
	public V getValue() throws DontHaveAValueException;
	public int getPriority();
	public IElementBuilder<V> getBuilder() throws BuildBlockOperatorException;
}
