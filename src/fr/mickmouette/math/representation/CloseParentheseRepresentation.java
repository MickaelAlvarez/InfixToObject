package fr.mickmouette.math.representation;

import fr.mickmouette.core.elements.IElementBuilder;
import fr.mickmouette.core.elements.representation.BlockEndOperatorRepresentation;

public class CloseParentheseRepresentation<T> extends BlockEndOperatorRepresentation<T> {

	@Override
	public int getPriority() {
		return 1;
	}

	@Override
	public IElementBuilder<T> getBuilder() {
		// TODO Exception
		return null;
	}

}
