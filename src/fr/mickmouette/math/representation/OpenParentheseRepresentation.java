package fr.mickmouette.math.representation;

import java.util.ArrayList;

import fr.mickmouette.core.elements.IElementBuilder;
import fr.mickmouette.core.elements.IEquation;
import fr.mickmouette.core.elements.exception.BuildException;
import fr.mickmouette.core.elements.representation.BlockStartOperatorRepresentation;
import fr.mickmouette.core.elements.representation.IElementRepresentation;

public class OpenParentheseRepresentation<T> extends BlockStartOperatorRepresentation<T> {

	@Override
	public int getPriority() {
		return 1;
	}

	@Override
	public IElementBuilder<T> getBuilder() {
		// TODO throx Exception
		return null;
	}

}
