package equationElements.binaryOperator.integer;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import elements.binaryOperator.BinaryOperator;
import elements.number.NumberInteger;
import elements.number.factory.NumberIntegerFactory;

public class BinaryOperatorTest {

    @Test
    public void testIntegerAndIntegerAddAbstraction() {
	int value1 = 1, value2 = 2, expected;
	expected = value1 + value2;
	
	BinaryOperator<Integer, NumberInteger> addOperator = new BinaryOperator<Integer, NumberInteger>(new NumberInteger(value1), new NumberInteger(value2)) {
	    @Override
	    public Integer solve() {
		return leftOperand.add(rightOperand);
	    }
	};
	
	assertEquals(expected, addOperator.solve().intValue());
    }

    @Test
    public void testIntegerAndAdderAddAbstraction() {
	int value1 = 1, value2 = 2, value3 = 3, expected;
	expected = value1 + (value2 + value3);
	
	BinaryOperator<Integer, NumberInteger> rightOperand = new BinaryOperator<Integer, NumberInteger>(new NumberInteger(value2), new NumberInteger(value3)) {
	    @Override
	    public Integer solve() {
		return leftOperand.add(rightOperand);
	    }
	};
	
	BinaryOperator<Integer, NumberInteger> addOperator = new BinaryOperator<Integer, NumberInteger>(new NumberInteger(value1), rightOperand, new NumberIntegerFactory()) {
	    @Override
	    public Integer solve() {
		return leftOperand.add(rightOperand);
	    }
	};
	
	assertEquals(expected, addOperator.solve().intValue());
    }
    
    @Test
    public void testAdderAndIntegerAddAbstraction() {
	int value1 = 1, value2 = 2, value3 = 3, expected;
	expected = (value1 + value2) + value3;
	
	BinaryOperator<Integer, NumberInteger> leftOperand = new BinaryOperator<Integer, NumberInteger>(new NumberInteger(value1), new NumberInteger(value2)) {
	    @Override
	    public Integer solve() {
		return leftOperand.add(rightOperand);
	    }
	};
	
	BinaryOperator<Integer, NumberInteger> addOperator = new BinaryOperator<Integer, NumberInteger>(leftOperand, new NumberInteger(value3), new NumberIntegerFactory()) {
	    @Override
	    public Integer solve() {
		return leftOperand.add(rightOperand);
	    }
	};
	
	assertEquals(expected, addOperator.solve().intValue());
    }
    
    @Test
    public void testAdderAndAdderAddAbstraction() {
	int value1 = 1, value2 = 2, value3 = 3, value4 = 4, expected;
	expected = (value1 + value2) + (value3 + value4);
	
	BinaryOperator<Integer, NumberInteger> leftOperand = new BinaryOperator<Integer, NumberInteger>(new NumberInteger(value1), new NumberInteger(value2)) {
	    @Override
	    public Integer solve() {
		return leftOperand.add(rightOperand);
	    }
	};
	
	BinaryOperator<Integer, NumberInteger> rigthOperand = new BinaryOperator<Integer, NumberInteger>(new NumberInteger(value3), new NumberInteger(value4)) {
	    @Override
	    public Integer solve() {
		return leftOperand.add(rightOperand);
	    }
	};
	
	BinaryOperator<Integer, NumberInteger> addOperator = new BinaryOperator<Integer, NumberInteger>(leftOperand, rigthOperand, new NumberIntegerFactory()) {
	    @Override
	    public Integer solve() {
		return leftOperand.add(rightOperand);
	    }
	};
	
	assertEquals(expected, addOperator.solve().intValue());
    }
}
