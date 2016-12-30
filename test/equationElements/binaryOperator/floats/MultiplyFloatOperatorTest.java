package equationElements.binaryOperator.floats;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import elements.binaryOperator.IBinaryOperator;
import elements.binaryOperator.Multiplier;
import elements.number.NumberFloat;
import elements.number.factory.NumberFloatFactory;

public class MultiplyFloatOperatorTest {

    @Test
    public void multiplyFloatAndFloatValuesTest() {
	float value1 = 21.213f, value2 = 2.123f, expected;
	expected = value1 * value2;
	IBinaryOperator<Float> multiplier = new Multiplier<Float, NumberFloat>(new NumberFloat(value1), new NumberFloat(value2));
	assertEquals(expected, multiplier.solve().floatValue(), 0);
    }
    
    @Test
    public void multiplyFloatAndMultiplierValuesTest() {
	float value1 = 2.123f, value2 = 2.123f, value3 = 2.123f, expected;
	expected = value1 * (value2 * value3);
	IBinaryOperator<Float> rightOperand = new Multiplier<Float, NumberFloat>(new NumberFloat(value2), new NumberFloat(value3));
	IBinaryOperator<Float> multiplier = new Multiplier<Float, NumberFloat>(new NumberFloat(value1), rightOperand, new NumberFloatFactory());
	assertEquals(expected, multiplier.solve().floatValue(), 0);
    }
    
    @Test
    public void multiplyMultiplierAndFloatValuesTest() {
	float value1 = 2.123f, value2 = 2.123f, value3 = 2.123f, expected;
	expected = (value1 * value2) * value3;
	IBinaryOperator<Float> leftOperand = new Multiplier<Float, NumberFloat>(new NumberFloat(value1), new NumberFloat(value2));
	IBinaryOperator<Float> multiplier = new Multiplier<Float, NumberFloat>(leftOperand, new NumberFloat(value3), new NumberFloatFactory());
	assertEquals(expected, multiplier.solve().floatValue(), 0);
    }
    
    @Test
    public void multiplyMultiplierAndMultiplierValuesTest() {
	float value1 = 2, value2 = 2, value3 = 2, value4 = 2, expected;
	expected = (value1 * value2) * (value3 * value4);
	IBinaryOperator<Float> leftOperand = new Multiplier<Float, NumberFloat>(new NumberFloat(value1), new NumberFloat(value2));
	IBinaryOperator<Float> rightOperand = new Multiplier<Float, NumberFloat>(new NumberFloat(value3), new NumberFloat(value4));
	IBinaryOperator<Float> multiplier = new Multiplier<Float, NumberFloat>(leftOperand, rightOperand, new NumberFloatFactory());
	assertEquals(expected, multiplier.solve().floatValue(), 0);
    }

}
