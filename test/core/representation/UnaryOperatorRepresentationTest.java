package core.representation;

import static org.junit.Assert.*;

import org.junit.Test;

import fr.mickmouette.core.elements.IEquation;
import fr.mickmouette.core.elements.generated.UnaryOperator;
import fr.mickmouette.core.elements.representation.UnaryOperatorRepresentation;

public class UnaryOperatorRepresentationTest {
	private UnaryOperatorRepresentation<Void> representation = new UnaryOperatorRepresentation<Void>() {
		
		@Override
		public int getPriority() {
			return 0;
		}
		
		@Override
		protected UnaryOperator<Void> build(IEquation<Void> eq) {
			return new UnaryOperator<Void>(eq) {
				
				@Override
				public Void apply() {
					return null;
				}
			};
		}
	};

	@Test
	public void shouldNotBeABlock() {
		assertTrue(!representation.isBlockStart() && !representation.isBlockEnd());
	}
	
	@Test
	public void shouldBeAnOperator() {
		assertTrue(representation.isOperator());
	}
	
}
