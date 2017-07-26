package fr.mickmouette.math.representation;

import fr.mickmouette.core.elements.IElementBuilder;
import fr.mickmouette.core.elements.representation.BlockStartOperatorRepresentation;

public class OpenParentheseRepresentation<T> extends BlockStartOperatorRepresentation<T> {

	@Override
	public int getPriority() {
		return 1;
	}

	@Override
	public IElementBuilder<T> getBuilder() {
		// TODO throw Exception
		return null;
	}

}
