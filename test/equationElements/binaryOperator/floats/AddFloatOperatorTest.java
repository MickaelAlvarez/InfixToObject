package equationElements.binaryOperator.floats;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import elements.binaryOperator.Adder;
import elements.binaryOperator.IBinaryOperator;
import elements.number.NumberFloat;
import elements.number.factory.NumberFloatFactory;

public class AddFloatOperatorTest {

    @Test
    public void addIntegerAndIntegerValuesTest() {
	float value1 = 1.5f, value2 = 40.5f, expected;
	expected = value1 + value2;
	IBinaryOperator<Float> adder = new Adder<Float, NumberFloat>(new NumberFloat(value1), new NumberFloat(value2));
	assertEquals(expected, adder.solve().floatValue(), 0);
    }
    
    @Test
    public void addIntegerAndAdderValuesTest() {
	float value1 = 1.56f, value2 = 39.6f, value3 = 2.123f, expected;
	expected = value1 + value2 + value3;
	IBinaryOperator<Float> rightOperand = new Adder<Float, NumberFloat>(new NumberFloat(value2), new NumberFloat(value3));
	IBinaryOperator<Float> adder = new Adder<Float, NumberFloat>(new NumberFloat(value1), rightOperand, new NumberFloatFactory());
	assertEquals(expected, adder.solve().floatValue(), 0);
    }
    
    @Test
    public void addAdderAndIntegerValuesTest() {
	float value1 = 1.123f, value2 = 39.123f, value3 = 3.123f, expected;
	expected = value1 + value2 + value3;
	IBinaryOperator<Float> leftOperand = new Adder<Float, NumberFloat>(new NumberFloat(value1), new NumberFloat(value2));
	IBinaryOperator<Float> adder = new Adder<Float, NumberFloat>(leftOperand, new NumberFloat(value3), new NumberFloatFactory());
	assertEquals(expected, adder.solve().floatValue(), 0);
    }
    
    @Test
    public void addAdderAndAdderValuesTest() {
	float value1 = 1, value2 = 39, value3 = 1, value4 = 1, expected;
	expected = value1 + value2 + value3 + value4;
	IBinaryOperator<Float> leftOperand = new Adder<Float, NumberFloat>(new NumberFloat(value1), new NumberFloat(value2));
	IBinaryOperator<Float> rightOperand = new Adder<Float, NumberFloat>(new NumberFloat(value3), new NumberFloat(value4));
	IBinaryOperator<Float> adder = new Adder<Float, NumberFloat>(leftOperand, rightOperand, new NumberFloatFactory());
	assertEquals(expected, adder.solve().floatValue(), 0);
    }

}
