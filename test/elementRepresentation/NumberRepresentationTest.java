package elementRepresentation;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import fr.mickmouette.math.representation.DoubleNumberRepresentation;

public class NumberRepresentationTest {

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
	public void testAreNotOperator() {
		DoubleNumberRepresentation doubleR = new DoubleNumberRepresentation(0d);
		assertFalse(doubleR.isOperator());
	}

	@Test
	public void testDoubleNumberType() {
		DoubleNumberRepresentation doubleR = new DoubleNumberRepresentation(0d);
		assertTrue(!doubleR.isOperator() && !doubleR.isBlockStart() && !doubleR.isBlockEnd());
	}
	
	@Test
	public void testDoubleNumberValue() {
		double expected = 12.345d;
		DoubleNumberRepresentation doubleR = new DoubleNumberRepresentation(expected);
		assertEquals(expected, doubleR.getValue().doubleValue(), 0);
	}
	
	@Test
	public void testNumberPriority() {
		DoubleNumberRepresentation doubleR = new DoubleNumberRepresentation(0d);
		assertEquals(0, doubleR.getPriority());
	}
}
