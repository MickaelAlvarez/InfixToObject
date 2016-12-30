package equationElements.binaryOperator.doubles;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import elements.binaryOperator.Adder;
import elements.binaryOperator.IBinaryOperator;
import elements.number.NumberDouble;
import elements.number.factory.NumberDoubleFactory;

public class AddDoubleOperatorTest {

    @Test
    public void addDoubleAndDoubleValuesTest() {
	double value1 = 1, value2 = 41, expected;
	expected = value1 + value2;
	IBinaryOperator<Double> adder = new Adder<Double, NumberDouble>(new NumberDouble(value1), new NumberDouble(value2));
	assertEquals(expected, adder.solve().doubleValue(), 0);
    }
    
    @Test
    public void addDoubleAndAdderValuesTest() {
	double value1 = 1, value2 = 39, value3 = 2, expected;
	expected = value1 + value2 + value3;
	IBinaryOperator<Double> rightOperand = new Adder<Double, NumberDouble>(new NumberDouble(value2), new NumberDouble(value3));
	IBinaryOperator<Double> adder = new Adder<Double, NumberDouble>(new NumberDouble(value1), rightOperand, new NumberDoubleFactory());
	assertEquals(expected, adder.solve().doubleValue(), 0);
    }
    
    @Test
    public void addAdderAndDoubleValuesTest() {
	double value1 = 1, value2 = 39, value3 = 3, expected;
	expected = value1 + value2 + value3;
	IBinaryOperator<Double> leftOperand = new Adder<Double, NumberDouble>(new NumberDouble(value1), new NumberDouble(value2));
	IBinaryOperator<Double> adder = new Adder<Double, NumberDouble>(leftOperand, new NumberDouble(value3), new NumberDoubleFactory());
	assertEquals(expected, adder.solve().doubleValue(), 0);
    }
    
    @Test
    public void addAdderAndAdderValuesTest() {
	double value1 = 1, value2 = 39, value3 = 1, value4 = 1, expected;
	expected = value1 + value2 + value3 + value4;
	IBinaryOperator<Double> leftOperand = new Adder<Double, NumberDouble>(new NumberDouble(value1), new NumberDouble(value2));
	IBinaryOperator<Double> rightOperand = new Adder<Double, NumberDouble>(new NumberDouble(value3), new NumberDouble(value4));
	IBinaryOperator<Double> adder = new Adder<Double, NumberDouble>(leftOperand, rightOperand, new NumberDoubleFactory());
	assertEquals(expected, adder.solve().doubleValue(), 0);
    }

}
