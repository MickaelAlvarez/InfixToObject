package core.representation;

import static org.junit.Assert.*;

import org.junit.Test;

import fr.mickmouette.core.elements.exception.DontHaveAValueException;
import fr.mickmouette.core.elements.generated.ValueOperator;
import fr.mickmouette.core.elements.representation.ValueOperatorRepresentation;

public class ValueOperatorRepresentationTest {
	private static int VALUE = 123;
	private ValueOperatorRepresentation<Integer> classicalRepresentation = new ValueOperatorRepresentation<Integer>(VALUE) {
		
		@Override
		public Integer getValue() throws DontHaveAValueException {
			return value;
		}
		
		@Override
		protected ValueOperator<Integer> build() {
			return new ValueOperator<Integer>(value) {
				
				@Override
				public Integer apply() {
					return this.value;
				}
			};
		}
	};
	
	@Test
	public void shouldNotBeABlock() {
		assertTrue(!classicalRepresentation.isBlockEnd() && !classicalRepresentation.isBlockStart());
	}
	
	@Test
	public void shoulNotBeAnOperator() {
		assertTrue(!classicalRepresentation.isOperator());
	}
	
	@Test
	public void shouldReturnTheValue() {
		try {
			assertEquals(VALUE, classicalRepresentation.getValue().intValue());
		} catch (DontHaveAValueException e) {
			fail();
		}
	}
}
