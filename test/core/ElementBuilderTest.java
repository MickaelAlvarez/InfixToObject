package core;

import static org.junit.Assert.*;


import org.junit.Test;

import fr.mickmouette.core.elements.IEquation;
import fr.mickmouette.core.elements.exception.BuildBinaryOperatorException;
import fr.mickmouette.core.elements.exception.BuildValueOperatorException;
import fr.mickmouette.core.elements.generated.BinaryOperator;
import fr.mickmouette.core.elements.generated.ValueOperator;
import fr.mickmouette.core.elements.representation.BinaryOperatorRepresentation;
import fr.mickmouette.core.elements.representation.ValueOperatorRepresentation;

public class ElementBuilderTest {

	@Test
	public void UnaryRepresentationShoudBuildValueOperator() {
		ValueOperatorRepresentation<Void> representation = new FakeValueOperatorRepresentation(null);
		try {
			assertTrue(representation.getBuilder().buildValueOperator() instanceof ValueOperator<?>);
		} catch (BuildValueOperatorException e) {
			fail();
		}
	}
	
	@Test
	public void ValueRepresentationShouldNotBuildBinaryOperator() {
		ValueOperatorRepresentation<Void> representation = new FakeValueOperatorRepresentation(null);
		try {
			representation.getBuilder().buildBinaryOperator(null, null);
			fail();
		} catch (BuildBinaryOperatorException e) {
			// Should be thrown
		}
	}
	
	@Test
	public void BinaryRepresentationShoudBuildABinaryOperator() {
		BinaryOperatorRepresentation<Void> representation = new FakeBinaryOperatorRepresentation();
		try {
			assertTrue(representation.getBuilder().buildBinaryOperator(null, null) instanceof BinaryOperator<?>);
		} catch (BuildBinaryOperatorException e) {
			fail();
		}
	}
	
	@Test
	public void BinaryRepresentationShouldNotBuildUnaryOperator() {
		BinaryOperatorRepresentation<Void> representation = new FakeBinaryOperatorRepresentation();
		try {
			representation.getBuilder().buildValueOperator();
			fail();
		} catch (BuildValueOperatorException e) {
			// Should be thrown
		}
	}
	
	private class FakeValueOperatorRepresentation extends ValueOperatorRepresentation<Void> {

		public FakeValueOperatorRepresentation(Void value) {
			super(value);
		}

		@Override
		public Void getValue() {
			return null;
		}

		@Override
		protected ValueOperator<Void> build() {
			return new ValueOperator<Void>(null) {
				@Override
				public Void apply() {
					return null;
				}
				
			};
		}
	}
	
	private class FakeBinaryOperatorRepresentation extends BinaryOperatorRepresentation<Void> {
		
		@Override
		public int getPriority() {
			return 0;
		}

		@Override
		protected BinaryOperator<Void> build(IEquation<Void> leftEq, IEquation<Void> rightEq) {
			return new BinaryOperator<Void>(null, null) {
				@Override
				public Void apply() {
					return null;
				}
			};
		}
		
	}
}
