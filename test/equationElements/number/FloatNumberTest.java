package equationElements.number;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import elements.number.INumber;
import elements.number.NumberFloat;

public class FloatNumberTest {

    @Test
    public void FloatNumbershouldReturnTheFloatValue() {
        float expected = 42;
        INumber<Float> number = new NumberFloat(expected);
        assertEquals(expected, number.getValue().floatValue(), 0);
    }

    @Test
    public void FloatNumbershouldAddAnotherIntegerNumber() {
        float value1 = 38.5f, value2 = 2.5f, expected;
        expected = value1 + value2;
        INumber<Float> number1 = new NumberFloat(value1);
        INumber<Float> number2 = new NumberFloat(value2);
        assertEquals(expected, number1.add(number2).floatValue(), 0);
    }

    @Test
    public void FloatNumbershouldMultiplyAnotherFloatNumber() {
        float value1 = 21, value2 = 2, expected;
        expected = value1 * value2;
        INumber<Float> number1 = new NumberFloat(value1);
        INumber<Float> number2 = new NumberFloat(value2);
        assertEquals(expected, number1.multiply(number2).floatValue(), 0);
    }

    @Test
    public void FloatNumbershouldSubtractAnotherFloatNumber() {
        float value1 = 43, value2 = 1, expected;
        expected = value1 - value2;
        INumber<Float> number1 = new NumberFloat(value1);
        INumber<Float> number2 = new NumberFloat(value2);
        assertEquals(expected, number1.substract(number2).floatValue(), 0);
    }
}
