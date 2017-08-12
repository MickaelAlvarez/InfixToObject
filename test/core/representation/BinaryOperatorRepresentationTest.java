package core.representation;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

import fr.mickmouette.core.elements.IEquation;
import fr.mickmouette.core.elements.exception.DontHaveAValueException;
import fr.mickmouette.core.elements.generated.BinaryOperator;
import fr.mickmouette.core.elements.representation.BinaryOperatorRepresentation;

public class BinaryOperatorRepresentationTest {
	private BinaryOperatorRepresentation<Void> representation;
	
	@Before
	public void setAll() {
		representation = new BinaryOperatorRepresentation<Void>() {
			@Override
			public int getPriority() {
				return -1;
			}
			
			@Override
			protected BinaryOperator<Void> build(IEquation<Void> leftEq, IEquation<Void> rightEq) {
				return new BinaryOperator<Void>(leftEq, rightEq) {
					@Override
					public Void apply() {
						return null;
					}
				};
			}
		};
	}

	@Test
	public void shouldNotBeABlock() {
		assertFalse(representation.isBlockStart());
		assertFalse(representation.isBlockEnd());
	}
	
	@Test
	public void shouldBeAnOperator() {
		assertTrue(representation.isOperator());
	}
	
	@Test
	public void shouldDontHaveAValue() {
		try {
			representation.getValue();
			fail();
		} catch (DontHaveAValueException e) {
			// Should be thrown
		}
	}
}
