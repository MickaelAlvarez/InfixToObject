package fr.mickmouette.math.representation;

import fr.mickmouette.core.elements.representation.BlockEndOperatorRepresentation;

public class CloseParentheseRepresentation<T> extends BlockEndOperatorRepresentation<T> {

	@Override
	public int getPriority() {
		return 1;
	}

}
