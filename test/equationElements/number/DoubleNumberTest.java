package equationElements.number;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import elements.number.INumber;
import elements.number.NumberDouble;

public class DoubleNumberTest {

	@Test
	public void DoubleNumbershouldReturnTheFloatValue() {
		double expected = 42;
		INumber<Double> number = new NumberDouble(expected);
		assertEquals(expected, number.getValue().doubleValue(), 0);
	}

	@Test
	public void DoubleNumbershouldAddAnotherDoubleNumber() {
		double value1 = 38.5f, value2 = 2.5f, expected;
		expected = value1 + value2;
		INumber<Double> number1 = new NumberDouble(value1);
		INumber<Double> number2 = new NumberDouble(value2);
		assertEquals(expected, number1.add(number2).doubleValue(), 0);
	}

	@Test
	public void DoubleNumbershouldMultiplyAnotherDoubleNumber() {
		double value1 = 21.05, value2 = 2.0111, expected;
		expected = value1 * value2;
		INumber<Double> number1 = new NumberDouble(value1);
		INumber<Double> number2 = new NumberDouble(value2);
		assertEquals(expected, number1.multiply(number2).doubleValue(), 0);
	}

	@Test
	public void DoubleNumbershouldSubtractAnotherDoubleNumber() {
		double value1 = 43, value2 = 1, expected;
		expected = value1 - value2;
		INumber<Double> number1 = new NumberDouble(value1);
		INumber<Double> number2 = new NumberDouble(value2);
		assertEquals(expected, number1.substract(number2).doubleValue(), 0);
	}

}
