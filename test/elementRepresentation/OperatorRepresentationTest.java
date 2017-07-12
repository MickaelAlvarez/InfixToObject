package elementRepresentation;

import static org.junit.Assert.*;

import org.junit.Test;

import elements.IEquation;
import elements.binaryOperator.Adder;
import elements.binaryOperator.Multiplier;
import elements.binaryOperator.Subtractor;
import elements.representation.operator.AdditionRepresentation;
import elements.representation.operator.MultiplicationRepresentation;
import elements.representation.operator.OperatorRepresentation;
import elements.representation.operator.SubstractRepresentation;

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
