package elementRepresentation;

import static org.junit.Assert.*;

import org.junit.Test;

import fr.mickmouette.core.elements.IEquation;
import fr.mickmouette.core.elements.representation.OperatorRepresentation;
import fr.mickmouette.math.generated.Adder;
import fr.mickmouette.math.generated.Multiplier;
import fr.mickmouette.math.generated.Subtractor;
import fr.mickmouette.math.representation.AdditionRepresentation;
import fr.mickmouette.math.representation.MultiplicationRepresentation;
import fr.mickmouette.math.representation.SubstractRepresentation;

public class OperatorRepresentationTest {
	private IEquation<Double> value = new IEquation<Double>() {
		
		@Override
		public Double apply() {
			return 1d;
		}
	};

	@Test
	public void testAreOperators() {
		AdditionRepresentation add = new AdditionRepresentation();
		SubstractRepresentation sub = new SubstractRepresentation();
		MultiplicationRepresentation mul = new MultiplicationRepresentation();
		assertTrue(add.isOperator() && sub.isOperator() && mul.isOperator());
	}
	
	@Test
	public void testAdditionPriority() {
		AdditionRepresentation representation = new AdditionRepresentation();
		assertEquals(2, representation.getPriority());
	}

	@Test
	public void testSubstractionPriority() {
		SubstractRepresentation representation = new SubstractRepresentation();
		assertEquals(2, representation.getPriority());
	}
	
	@Test
	public void testMultiplicationPriority() {
		MultiplicationRepresentation representation = new MultiplicationRepresentation();
		assertEquals(4, representation.getPriority());
	}
	
	@Test
    public void addRepresentationShouldBuildAnAdder() {
    	OperatorRepresentation<Double> addition = new AdditionRepresentation();
    	assertTrue(addition.build(value, value) instanceof Adder);
    }
	
	@Test
	public void substractionRepresentationShouldBuildASubstractor() {
		OperatorRepresentation<Double> subtractor = new SubstractRepresentation();
    	assertTrue(subtractor.build(value, value) instanceof Subtractor);
	}
	
	@Test
	public void multiplicationRepresentationShouldBuildAMultiplier() {
		OperatorRepresentation<Double> multiplier = new MultiplicationRepresentation();
    	assertTrue(multiplier.build(value, value) instanceof Multiplier);
	}
	
}
