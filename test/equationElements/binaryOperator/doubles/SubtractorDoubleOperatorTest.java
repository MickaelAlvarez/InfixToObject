package equationElements.binaryOperator.doubles;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import elements.binaryOperator.IBinaryOperator;
import elements.binaryOperator.Subtractor;
import elements.number.NumberDouble;
import elements.number.factory.NumberDoubleFactory;

public class SubtractorDoubleOperatorTest {

    @Test
    public void subtractDoubleAndDoubleValuesTest() {
	double value1 = 43, value2 = 1, expected;
	expected = value1 - value2;
	IBinaryOperator<Double> subtractor = new Subtractor<Double, NumberDouble>(new NumberDouble(value1),
		new NumberDouble(value2));
	assertEquals(expected, subtractor.solve().doubleValue(), 0);
    }

    @Test
    public void subtractDoubleAndSubtractorValuesTest() {
	double value1 = 46, value2 = 4, value3 = 2, expected;
	expected = value1 - (value2 - value3);
	IBinaryOperator<Double> rightOperand = new Subtractor<Double, NumberDouble>(new NumberDouble(value2),
		new NumberDouble(value3));
	IBinaryOperator<Double> adder = new Subtractor<Double, NumberDouble>(new NumberDouble(value1), rightOperand,
		new NumberDoubleFactory());
	assertEquals(expected, adder.solve().doubleValue(), 0);
    }

    @Test
    public void subtractSubtractorAndDoubleValuesTest() {
	double value1 = 45, value2 = 2, value3 = 1, expected;
	expected = (value1 - value2) - value3;
	IBinaryOperator<Double> leftOperand = new Subtractor<Double, NumberDouble>(new NumberDouble(value1),
		new NumberDouble(value2));
	IBinaryOperator<Double> adder = new Subtractor<Double, NumberDouble>(leftOperand, new NumberDouble(value3),
		new NumberDoubleFactory());
	assertEquals(expected, adder.solve().doubleValue(), 0);
    }

    @Test
    public void addAdderAndAdderValuesTest() {
	double value1 = 50, value2 = 5, value3 = 4, value4 = 1, expected;
	expected = (value1 - value2) - (value3 - value4);
	IBinaryOperator<Double> leftOperand = new Subtractor<Double, NumberDouble>(new NumberDouble(value1),
		new NumberDouble(value2));
	IBinaryOperator<Double> rightOperand = new Subtractor<Double, NumberDouble>(new NumberDouble(value3),
		new NumberDouble(value4));
	IBinaryOperator<Double> adder = new Subtractor<Double, NumberDouble>(leftOperand, rightOperand,
		new NumberDoubleFactory());
	assertEquals(expected, adder.solve().doubleValue(), 0);
    }

}
