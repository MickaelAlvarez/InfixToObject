package equationElements.number;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import elements.number.INumber;
import elements.number.NumberInteger;

public class IntegerNumberTest {

    @Test
    public void IntegerNumbershouldReturnTheIntegerValue() {
        int expected = 42;
        INumber<Integer> number = new NumberInteger(expected);
        assertEquals(expected, number.getValue().intValue());
    }

    @Test
    public void IntegerNumbershouldAddAnotherIntegerNumber() {
        int value1 = 39, value2 = 2, expected;
        expected = value1 + value2;
        INumber<Integer> number1 = new NumberInteger(value1);
        INumber<Integer> number2 = new NumberInteger(value2);
        assertEquals(expected, number1.add(number2).intValue());
    }

    @Test
    public void IntegerNumbershouldMultiplyAnotherIntegerNumber() {
        int value1 = 21, value2 = 2, expected;
        expected = value1 * value2;
        INumber<Integer> number1 = new NumberInteger(value1);
        INumber<Integer> number2 = new NumberInteger(value2);
        assertEquals(expected, number1.multiply(number2).intValue());
    }

    @Test
    public void IntegerNumbershouldSubtractAnotherIntegerNumber() {
        int value1 = 43, value2 = 1, expected;
        expected = value1 - value2;
        INumber<Integer> number1 = new NumberInteger(value1);
        INumber<Integer> number2 = new NumberInteger(value2);
        assertEquals(expected, number1.substract(number2).intValue());
    }
}
