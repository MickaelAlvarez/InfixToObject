package equationElements.binaryOperator.doubles;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import elements.binaryOperator.IBinaryOperator;
import elements.binaryOperator.Multiplier;
import elements.number.NumberDouble;
import elements.number.factory.NumberDoubleFactory;

public class MultiplyDoubleOperatorTest {

    @Test
    public void multiplyDoubleAndDoubleValuesTest() {
        double value1 = 21, value2 = 2, expected;
        expected = value1 * value2;
        IBinaryOperator<Double> multiplier = new Multiplier<Double, NumberDouble>(new NumberDouble(value1),
                new NumberDouble(value2));
        assertEquals(expected, multiplier.solve().doubleValue(), 0);
    }

    @Test
    public void multiplyDoubleAndMultiplierValuesTest() {
        double value1 = 2, value2 = 2, value3 = 2, expected;
        expected = value1 * (value2 * value3);
        IBinaryOperator<Double> rightOperand = new Multiplier<Double, NumberDouble>(new NumberDouble(value2),
                new NumberDouble(value3));
        IBinaryOperator<Double> multiplier = new Multiplier<Double, NumberDouble>(new NumberDouble(value1),
                rightOperand, new NumberDoubleFactory());
        assertEquals(expected, multiplier.solve().doubleValue(), 0);
    }

    @Test
    public void multiplyMultiplierAndDoubleValuesTest() {
        double value1 = 2, value2 = 2, value3 = 2, expected;
        expected = (value1 * value2) * value3;
        IBinaryOperator<Double> leftOperand = new Multiplier<Double, NumberDouble>(new NumberDouble(value1),
                new NumberDouble(value2));
        IBinaryOperator<Double> multiplier = new Multiplier<Double, NumberDouble>(leftOperand, new NumberDouble(value3),
                new NumberDoubleFactory());
        assertEquals(expected, multiplier.solve().doubleValue(), 0);
    }

    @Test
    public void multiplyMultiplierAndMultiplierValuesTest() {
        double value1 = 2, value2 = 2, value3 = 2, value4 = 2, expected;
        expected = (value1 * value2) * (value3 * value4);
        IBinaryOperator<Double> leftOperand = new Multiplier<Double, NumberDouble>(new NumberDouble(value1),
                new NumberDouble(value2));
        IBinaryOperator<Double> rightOperand = new Multiplier<Double, NumberDouble>(new NumberDouble(value3),
                new NumberDouble(value4));
        IBinaryOperator<Double> multiplier = new Multiplier<Double, NumberDouble>(leftOperand, rightOperand,
                new NumberDoubleFactory());
        assertEquals(expected, multiplier.solve().doubleValue(), 0);
    }

}
