package elementRepresentation;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import elements.representation.IElementRepresentation.Type;
import elements.representation.operator.AdditionRepresentation;
import elements.representation.operator.CloseParentheseRepresentation;
import elements.representation.operator.DivisionRepresentation;
import elements.representation.operator.MultiplicationRepresentation;
import elements.representation.operator.OpenParentheseRepresentation;
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
	public void testAdditionType() {
		AdditionRepresentation representation = new AdditionRepresentation();
		assertEquals(Type.ADDITION, representation.getType());
	}

	@Test
	public void testSubstractionType() {
		SubstractRepresentation representation = new SubstractRepresentation();
		assertEquals(Type.SUBSTRACTION, representation.getType());
	}
	
	@Test
	public void testMultiplicationType() {
		MultiplicationRepresentation representation = new MultiplicationRepresentation();
		assertEquals(Type.MULTIPLICATION, representation.getType());
	}
	
	@Test
	public void testDivisionType() {
		DivisionRepresentation representation = new DivisionRepresentation();
		assertEquals(Type.DIVISION, representation.getType());
	}
	
	@Test
	public void testPowerType() {
		PowerRepresentation representation = new PowerRepresentation();
		assertEquals(Type.POWER, representation.getType());
	}
	
	@Test
	public void testOpenParentheseType() {
		OpenParentheseRepresentation representation = new OpenParentheseRepresentation();
		assertEquals(Type.OPEN_PARENTHESE, representation.getType());
	}
	
	@Test
	public void testCloseParentheseType() {
		CloseParentheseRepresentation representation = new CloseParentheseRepresentation();
		assertEquals(Type.CLOSE_PARENTHESE, representation.getType());
	}
}
