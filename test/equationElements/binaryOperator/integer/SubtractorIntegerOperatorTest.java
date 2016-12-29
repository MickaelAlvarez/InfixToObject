package equationElements.binaryOperator.integer;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import elements.binaryOperator.IBinaryOperator;
import elements.binaryOperator.Subtractor;
import elements.number.NumberInteger;
import elements.number.factory.NumberIntegerFactory;

public class SubtractorIntegerOperatorTest {

	@Test
	public void subtractIntegerAndIntegerValuesTest() {
		int value1 = 43, value2 = 1, expected;
		expected = value1 - value2;
		IBinaryOperator<Integer> subtractor = new Subtractor<Integer, NumberInteger>(new NumberInteger(value1), new NumberInteger(value2));
		assertEquals(expected, subtractor.solve().intValue());
	}

	@Test
	public void subtractIntegerAndSubtractorValuesTest() {
		int value1 = 46, value2 = 4, value3 = 2, expected;
		expected = value1 - (value2 - value3);
		IBinaryOperator<Integer> rightOperand = new Subtractor<Integer, NumberInteger>(new NumberInteger(value2), new NumberInteger(value3));
		IBinaryOperator<Integer> adder = new Subtractor<Integer, NumberInteger>(new NumberInteger(value1), rightOperand, new NumberIntegerFactory());
		assertEquals(expected, adder.solve().intValue());
	}

	@Test
	public void subtractSubtractorAndIntegerValuesTest() {
		int value1 = 45, value2 = 2, value3 = 1, expected;
		expected = (value1 - value2) - value3;
		IBinaryOperator<Integer> leftOperand = new Subtractor<Integer, NumberInteger>(new NumberInteger(value1), new NumberInteger(value2));
		IBinaryOperator<Integer> adder = new Subtractor<Integer, NumberInteger>(leftOperand, new NumberInteger(value3), new NumberIntegerFactory());
		assertEquals(expected, adder.solve().intValue());
	}

	@Test
	public void addAdderAndAdderValuesTest() {
		int value1 = 50, value2 = 5, value3 = 4, value4 = 1, expected;
		expected = (value1 - value2) - (value3 - value4);
		IBinaryOperator<Integer> leftOperand = new Subtractor<Integer, NumberInteger>(new NumberInteger(value1), new NumberInteger(value2));
		IBinaryOperator<Integer> rightOperand = new Subtractor<Integer, NumberInteger>(new NumberInteger(value3), new NumberInteger(value4));
		IBinaryOperator<Integer> adder = new Subtractor<Integer, NumberInteger>(leftOperand, rightOperand, new NumberIntegerFactory());
		assertEquals(expected, adder.solve().intValue());
	}

}
