package equationElements.binaryOperator.floats;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import elements.binaryOperator.IBinaryOperator;
import elements.binaryOperator.Subtractor;
import elements.number.NumberFloat;
import elements.number.factory.NumberFloatFactory;

public class SubtratorFloatOperatorTest {

    @Test
    public void subtractFloatAndFloatValuesTest() {
        float value1 = 43, value2 = 1, expected;
        expected = value1 - value2;
        IBinaryOperator<Float> subtractor = new Subtractor<Float, NumberFloat>(new NumberFloat(value1),
                new NumberFloat(value2));
        assertEquals(expected, subtractor.solve().floatValue(), 0);
    }

    @Test
    public void subtractFloatAndSubtractorValuesTest() {
        float value1 = 46, value2 = 4, value3 = 2, expected;
        expected = value1 - (value2 - value3);
        IBinaryOperator<Float> rightOperand = new Subtractor<Float, NumberFloat>(new NumberFloat(value2),
                new NumberFloat(value3));
        IBinaryOperator<Float> adder = new Subtractor<Float, NumberFloat>(new NumberFloat(value1), rightOperand,
                new NumberFloatFactory());
        assertEquals(expected, adder.solve().floatValue(), 0);
    }

    @Test
    public void subtractSubtractorAndFloatValuesTest() {
        float value1 = 45, value2 = 2, value3 = 1, expected;
        expected = (value1 - value2) - value3;
        IBinaryOperator<Float> leftOperand = new Subtractor<Float, NumberFloat>(new NumberFloat(value1),
                new NumberFloat(value2));
        IBinaryOperator<Float> adder = new Subtractor<Float, NumberFloat>(leftOperand, new NumberFloat(value3),
                new NumberFloatFactory());
        assertEquals(expected, adder.solve().floatValue(), 0);
    }

    @Test
    public void addAdderAndAdderValuesTest() {
        float value1 = 50, value2 = 5, value3 = 4, value4 = 1, expected;
        expected = (value1 - value2) - (value3 - value4);
        IBinaryOperator<Float> leftOperand = new Subtractor<Float, NumberFloat>(new NumberFloat(value1),
                new NumberFloat(value2));
        IBinaryOperator<Float> rightOperand = new Subtractor<Float, NumberFloat>(new NumberFloat(value3),
                new NumberFloat(value4));
        IBinaryOperator<Float> adder = new Subtractor<Float, NumberFloat>(leftOperand, rightOperand,
                new NumberFloatFactory());
        assertEquals(expected, adder.solve().floatValue(), 0);
    }

}
