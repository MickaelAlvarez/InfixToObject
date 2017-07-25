package fr.mickmouette.core.elements.representation;

import java.util.ArrayList;

import fr.mickmouette.core.elements.IElementBuilder;
import fr.mickmouette.core.elements.IEquation;
import fr.mickmouette.core.elements.exception.BuildBlockOperatorException;
import fr.mickmouette.core.elements.exception.BuildException;
import fr.mickmouette.core.elements.exception.DontHaveAValueException;
import fr.mickmouette.core.elements.exception.convertion.OperandBlockRepresentationOperatorException;

public abstract class BlockRepresentation<T> implements IElementRepresentation<T> {
	
	@Override
	public boolean isOperator() {
		return true;
	}

	@Override
	public T getValue() throws DontHaveAValueException {
		throw new DontHaveAValueException();
	}
	
	@Override
	public IElementBuilder<T> getBuilder() throws BuildBlockOperatorException {
		throw new BuildBlockOperatorException();
	}
	
	@Override
	public IEquation<T> convert(ArrayList<IElementRepresentation<T>> equation) throws BuildException {
		throw new OperandBlockRepresentationOperatorException();
	}
}
