package fr.mickmouette.math.representation;

import fr.mickmouette.core.elements.representation.BlockStartOperatorRepresentation;

public class OpenParentheseRepresentation<T> extends BlockStartOperatorRepresentation<T> {

	@Override
	public int getPriority() {
		return 1;
	}

}
