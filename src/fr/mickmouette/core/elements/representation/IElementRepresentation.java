package fr.mickmouette.core.elements.representation;

import java.util.ArrayList;

import fr.mickmouette.core.elements.IElementBuilder;
import fr.mickmouette.core.elements.IEquation;
import fr.mickmouette.core.elements.exception.BuildBlockOperatorException;
import fr.mickmouette.core.elements.exception.BuildException;
import fr.mickmouette.core.elements.exception.DontHaveAValueException;
import fr.mickmouette.core.elements.exception.convertion.ConvertionException;

public interface IElementRepresentation<V> {
	public boolean isOperator();
	public boolean isBlockStart();
	public boolean isBlockEnd();
	public V getValue() throws DontHaveAValueException;
	public int getPriority();
	public IElementBuilder<V> getBuilder() throws BuildBlockOperatorException;
	public IEquation<V> convert(ArrayList<IElementRepresentation<V>> equation) throws BuildException, ConvertionException;
}
