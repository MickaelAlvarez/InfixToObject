package core.representation;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Test;

import fr.mickmouette.core.elements.exception.DontHaveAValueException;
import fr.mickmouette.core.elements.representation.BlockEndOperatorRepresentation;
import fr.mickmouette.core.elements.representation.BlockStartOperatorRepresentation;

public class BlockOperatorRepresentationTest {
	private BlockEndOperatorRepresentation<Void> representationEnd = new BlockEndOperatorRepresentation<Void>() {
		@Override
		public int getPriority() {
			return 0;
		}
	};
	
	private BlockStartOperatorRepresentation<Void> representationStart = new BlockStartOperatorRepresentation<Void>() {
		@Override
		public int getPriority() {
			return 0;
		}
	};
	
	@Test
	public void blockStart() {
		assertTrue(representationStart.isOperator() && representationStart.isBlockStart());
	}
	
	@Test
	public void blockEnd() {
		assertTrue(representationEnd.isOperator() && representationEnd.isBlockEnd());
	}
	
	@Test
	public void shouldDontHaveAValue() {
		try {
			representationStart.getValue();
			representationEnd.getValue();
			fail();
		} catch (DontHaveAValueException e) {
			// Should dont be thrown
		}
	}
}
