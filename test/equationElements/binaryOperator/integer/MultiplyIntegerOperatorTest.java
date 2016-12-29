package equationElements.binaryOperator.integer;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import elements.binaryOperator.Adder;
import elements.binaryOperator.IBinaryOperator;
import elements.binaryOperator.Multiplier;
import elements.number.NumberInteger;
import elements.number.factory.NumberIntegerFactory;

public class MultiplyIntegerOperatorTest {

    @Test
    public void multiplyIntegerAndIntegerValuesTest() {
	int value1 = 21, value2 = 2, expected;
	expected = value1 * value2;
	IBinaryOperator<Integer> multiplier = new Multiplier<Integer, NumberInteger>(new NumberInteger(value1), new NumberInteger(value2));
	assertEquals(expected, multiplier.solve().intValue());
    }
    
    @Test
    public void multiplyIntegerAndMultiplierValuesTest() {
	int value1 = 2, value2 = 2, value3 = 2, expected;
	expected = value1 * (value2 * value3);
	IBinaryOperator<Integer> rightOperand = new Multiplier<Integer, NumberInteger>(new NumberInteger(value2), new NumberInteger(value3));
	IBinaryOperator<Integer> multiplier = new Multiplier<Integer, NumberInteger>(new NumberInteger(value1), rightOperand, new NumberIntegerFactory());
	assertEquals(expected, multiplier.solve().intValue());
    }
    
    @Test
    public void multiplyMultiplierAndIntegerValuesTest() {
	int value1 = 2, value2 = 2, value3 = 2, expected;
	expected = (value1 * value2) * value3;
	IBinaryOperator<Integer> leftOperand = new Multiplier<Integer, NumberInteger>(new NumberInteger(value1), new NumberInteger(value2));
	IBinaryOperator<Integer> multiplier = new Multiplier<Integer, NumberInteger>(leftOperand, new NumberInteger(value3), new NumberIntegerFactory());
	assertEquals(expected, multiplier.solve().intValue());
    }
    
    @Test
    public void multiplyMultiplierAndMultiplierValuesTest() {
	int value1 = 2, value2 = 2, value3 = 2, value4 = 2, expected;
	expected = (value1 * value2) * (value3 * value4);
	IBinaryOperator<Integer> leftOperand = new Multiplier<Integer, NumberInteger>(new NumberInteger(value1), new NumberInteger(value2));
	IBinaryOperator<Integer> rightOperand = new Multiplier<Integer, NumberInteger>(new NumberInteger(value3), new NumberInteger(value4));
	IBinaryOperator<Integer> multiplier = new Multiplier<Integer, NumberInteger>(leftOperand, rightOperand, new NumberIntegerFactory());
	assertEquals(expected, multiplier.solve().intValue());
    }
    
    @Test
    public void multiplyIntegerAndAdderValuesTest() {
	int value1 = 21, value2 = 1, value3 = 1, expected;
	expected = value1 * (value2 + value3);
	IBinaryOperator<Integer> leftOperand = new Adder<Integer, NumberInteger>(new NumberInteger(value2), new NumberInteger(value3));
	IBinaryOperator<Integer> multiplier = new Multiplier<Integer, NumberInteger>(new NumberInteger(value1), leftOperand, new NumberIntegerFactory());
	assertEquals(expected, multiplier.solve().intValue());
    }
    
    @Test
    public void multiplyAdderAndIntegerValuesTest() {
	int value1 = 1, value2 = 1, value3 = 21, expected;
	expected = (value1 + value2) * value3;
	IBinaryOperator<Integer> rigthOperand = new Adder<Integer, NumberInteger>(new NumberInteger(value1), new NumberInteger(value2));
	IBinaryOperator<Integer> multiplier = new Multiplier<Integer, NumberInteger>(rigthOperand, new NumberInteger(value3), new NumberIntegerFactory());
	assertEquals(expected, multiplier.solve().intValue());
    }
    
    @Test
    public void multiplyAdderAndAdderValuesTest() {
	int value1 = 1, value2 = 1, value3 = 1, value4 = 20, expected;
	expected = (value1 + value2) * (value3 + value4);
	IBinaryOperator<Integer> rigthOperand = new Adder<Integer, NumberInteger>(new NumberInteger(value1), new NumberInteger(value2));
	IBinaryOperator<Integer> leftOperand = new Adder<Integer, NumberInteger>(new NumberInteger(value3), new NumberInteger(value4));
	IBinaryOperator<Integer> multiplier = new Multiplier<Integer, NumberInteger>(rigthOperand, leftOperand, new NumberIntegerFactory());
	assertEquals(expected, multiplier.solve().intValue());
    }

}
