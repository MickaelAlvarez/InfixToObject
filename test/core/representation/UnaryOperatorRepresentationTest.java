package core.representation;

import static org.junit.Assert.*;

import org.junit.Test;

import fr.mickmouette.core.elements.IEquation;
import fr.mickmouette.core.elements.exception.BuildBinaryOperatorException;
import fr.mickmouette.core.elements.exception.BuildBlockOperatorException;
import fr.mickmouette.core.elements.exception.BuildUnaryOperatorException;
import fr.mickmouette.core.elements.exception.BuildValueOperatorException;
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
	
	@Test
	public void shouldNotBuildAValueOperator() {
		try {
			representation.getBuilder().buildValueOperator();
			fail();
		} catch (BuildValueOperatorException e) {
		} catch (BuildBlockOperatorException e) {
		}
	}
	
	@Test
	public void shouldNotBuildABinaryOperator() {
		try {
			representation.getBuilder().buildBinaryOperator(null, null);
			fail();
		} catch (BuildBlockOperatorException e) {
		} catch (BuildBinaryOperatorException e) {
		}
	}
	
	@Test
	public void shouldBuildAnUnaryOperator() {
		try {
			representation.getBuilder().buildUnaryOperator(null);
		} catch (BuildUnaryOperatorException e) {
			fail();
		} catch (BuildBlockOperatorException e) {
			fail();
		}
	}
	
}
