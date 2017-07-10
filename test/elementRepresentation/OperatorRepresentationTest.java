package elementRepresentation;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import elements.binaryOperator.Adder;
import elements.binaryOperator.Multiplier;
import elements.binaryOperator.Subtractor;
import elements.number.NumberDouble;
import elements.number.factory.NumberDoubleFactory;
import elements.representation.operator.AdditionRepresentation;
import elements.representation.operator.CloseParentheseRepresentation;
import elements.representation.operator.DivisionRepresentation;
import elements.representation.operator.MultiplicationRepresentation;
import elements.representation.operator.OpenParentheseRepresentation;
import elements.representation.operator.OperatorRepresentation;
import elements.representation.operator.PowerRepresentation;
import elements.representation.operator.SubstractRepresentation;

public class OperatorRepresentationTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testAreOperators() {
		AdditionRepresentation add = new AdditionRepresentation();
		SubstractRepresentation sub = new SubstractRepresentation();
		MultiplicationRepresentation mul = new MultiplicationRepresentation();
		DivisionRepresentation div = new DivisionRepresentation();
		PowerRepresentation pow = new PowerRepresentation();
		OpenParentheseRepresentation openParenthese = new OpenParentheseRepresentation();
		CloseParentheseRepresentation closeParenthese = new CloseParentheseRepresentation();
		assertTrue(add.isOperator() && sub.isOperator() && mul.isOperator() && div.isOperator() && pow.isOperator() && openParenthese.isOperator() && closeParenthese.isOperator());
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
	public void testDivisionPriority() {
		DivisionRepresentation representation = new DivisionRepresentation();
		assertEquals(4, representation.getPriority());
	}
	
	@Test
	public void testPowerPriority() {
		PowerRepresentation representation = new PowerRepresentation();
		assertEquals(6, representation.getPriority());
	}
	
	@Test
	public void testOpenParenthesePriority() {
		OpenParentheseRepresentation representation = new OpenParentheseRepresentation();
		assertEquals(1, representation.getPriority());
	}
	
	@Test
	public void testCloseParenthesePriority() {
		CloseParentheseRepresentation representation = new CloseParentheseRepresentation();
		assertEquals(1, representation.getPriority());
	}
	
	@Test
    public void addRepresentationShouldBuildAnAdder() {
    	OperatorRepresentation<Double, NumberDouble> addition = new AdditionRepresentation<Double, NumberDouble>();
    	assertTrue(addition.build(new NumberDouble(0d), new NumberDouble(0d), new NumberDoubleFactory()) instanceof Adder<?,?>);
    }
	
	@Test
	public void substractionRepresentationShouldBuildASubstractor() {
		OperatorRepresentation<Double, NumberDouble> subtractor = new SubstractRepresentation<Double, NumberDouble>();
    	assertTrue(subtractor.build(new NumberDouble(0d), new NumberDouble(0d), new NumberDoubleFactory()) instanceof Subtractor<?, ?>);
	}
	
	@Test
	public void multiplicationRepresentationShouldBuildAMultiplier() {
		OperatorRepresentation<Double, NumberDouble> multiplier = new MultiplicationRepresentation<Double, NumberDouble>();
    	assertTrue(multiplier.build(new NumberDouble(0d), new NumberDouble(0d), new NumberDoubleFactory()) instanceof Multiplier<?, ?>);
	}
	
}
