package equationElements.binaryOperator.integer;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import elements.binaryOperator.Adder;
import elements.binaryOperator.IBinaryOperator;
import elements.binaryOperator.Multiplier;
import elements.number.NumberInteger;
import elements.number.factory.NumberIntegerFactory;

public class AddIntegerOperatorTest {
    
    @Test
    public void addIntegerAndIntegerValuesTest() {
	int value1 = 1, value2 = 41, expected;
	expected = value1 + value2;
	IBinaryOperator<Integer> adder = new Adder<Integer, NumberInteger>(new NumberInteger(value1), new NumberInteger(value2));
	assertEquals(expected, adder.solve().intValue());
    }
    
    @Test
    public void addIntegerAndAdderValuesTest() {
	int value1 = 1, value2 = 39, value3 = 2, expected;
	expected = value1 + value2 + value3;
	IBinaryOperator<Integer> rightOperand = new Adder<Integer, NumberInteger>(new NumberInteger(value2), new NumberInteger(value3));
	IBinaryOperator<Integer> adder = new Adder<Integer, NumberInteger>(new NumberInteger(value1), rightOperand, new NumberIntegerFactory());
	assertEquals(expected, adder.solve().intValue());
    }
    
    @Test
    public void addAdderAndIntegerValuesTest() {
	int value1 = 1, value2 = 39, value3 = 3, expected;
	expected = value1 + value2 + value3;
	IBinaryOperator<Integer> leftOperand = new Adder<Integer, NumberInteger>(new NumberInteger(value1), new NumberInteger(value2));
	IBinaryOperator<Integer> adder = new Adder<Integer, NumberInteger>(leftOperand, new NumberInteger(value3), new NumberIntegerFactory());
	assertEquals(expected, adder.solve().intValue());
    }
    
    @Test
    public void addAdderAndAdderValuesTest() {
	int value1 = 1, value2 = 39, value3 = 1, value4 = 1, expected;
	expected = value1 + value2 + value3 + value4;
	IBinaryOperator<Integer> leftOperand = new Adder<Integer, NumberInteger>(new NumberInteger(value1), new NumberInteger(value2));
	IBinaryOperator<Integer> rightOperand = new Adder<Integer, NumberInteger>(new NumberInteger(value3), new NumberInteger(value4));
	IBinaryOperator<Integer> adder = new Adder<Integer, NumberInteger>(leftOperand, rightOperand, new NumberIntegerFactory());
	assertEquals(expected, adder.solve().intValue());
    }
    
    @Test
    public void addMultiplierAndIntegerValuesTest() {
	int value1 = 2, value2 = 20, value3 = 2, expected;
	expected = value1 * value2 + value3;
	IBinaryOperator<Integer> adder = new Adder<Integer, NumberInteger>(new Multiplier<Integer, NumberInteger>(new NumberInteger(value1), new NumberInteger(value2)), new NumberInteger(value3), new NumberIntegerFactory());
	assertEquals(expected, adder.solve().intValue());
    }
    
    @Test
    public void addIntegerAndMultiplierValuesTest() {
	int value1 = 2, value2 = 20, value3 = 2, expected;
	expected = value1 + value2 * value3;
	IBinaryOperator<Integer> adder = new Adder<Integer, NumberInteger>(new NumberInteger(value1), new Multiplier<Integer, NumberInteger>(new NumberInteger(value2), new NumberInteger(value3)), new NumberIntegerFactory());
	assertEquals(expected, adder.solve().intValue());
    }

    @Test
    public void addMultiplierAndMultiplierValuesTest() {
	int value1 = 7, value2 = 3, value3 = 3, value4 = 7, expected;
	expected = value1 * value2 + value3 * value4;
	IBinaryOperator<Integer> adder = new Adder<Integer, NumberInteger>(new Multiplier<Integer, NumberInteger>(new NumberInteger(value1), new NumberInteger(value2)), new Multiplier<Integer, NumberInteger>(new NumberInteger(value3), new NumberInteger(value4)), new NumberIntegerFactory());
	assertEquals(expected, adder.solve().intValue());
    }
    
}
