package engine;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import elements.binaryOperator.Adder;
import elements.binaryOperator.IBinaryOperator;
import elements.number.INumber;
import elements.number.NumberDouble;
import elements.representation.IElementRepresentation;
import elements.representation.number.DoubleNumberRepresentation;
import elements.representation.operator.AdditionRepresentation;
import elements.representation.operator.SubstractRepresentation;
import engine.exception.WrongPrefixFormatError;

public class InfixConvertorTest {
    private InfixConvertor convertor;

    @Before
    public void before() {
        convertor = new InfixConvertor(new PrefixToObject());
    }

    @Test
    public void shouldConvertANumber() {
    	ArrayList<IElementRepresentation> INPUT = new ArrayList<>();
    	IElementRepresentation value = new DoubleNumberRepresentation(1);
    	INPUT.add(value);
        try {
        	assertTrue(convertor.convert(INPUT) instanceof INumber<?>);
            assertEquals(value.getDouble(), convertor.convert(INPUT).solve().doubleValue(), 0);
        } catch (WrongPrefixFormatError e) {
            fail();
        }

    }

    @Test
    public void shouldConvertAnOtherNumber() {
    	ArrayList<IElementRepresentation> INPUT = new ArrayList<>();
    	IElementRepresentation value = new DoubleNumberRepresentation(10);
    	INPUT.add(value);
        try {
        	assertTrue(convertor.convert(INPUT) instanceof INumber<?>); 
            assertEquals(value.getDouble(), convertor.convert(INPUT).solve().doubleValue(), 0);
        } catch (WrongPrefixFormatError e) {
            fail();
        }
    }
    
    @Test
    public void shouldConvertAnAdditionOfTwoNumbers() {
    	ArrayList<IElementRepresentation> INPUT = new ArrayList<>();
    	IElementRepresentation value = new DoubleNumberRepresentation(1);
    	IElementRepresentation add = new AdditionRepresentation();
    	IElementRepresentation value2 = new DoubleNumberRepresentation(1);
    	INPUT.add(value);
    	INPUT.add(add);
    	INPUT.add(value2);
        try {
        	assertTrue(convertor.convert(INPUT) instanceof IBinaryOperator<?>);
            assertEquals(2, convertor.convert(INPUT).solve().doubleValue(), 0);
        } catch (WrongPrefixFormatError e) {
            fail();
        }
    }
    
    @Test
    public void shouldConvertAnAdditionOfANumberAndABinaryOperator() {
    	ArrayList<IElementRepresentation> INPUT = new ArrayList<>();
    	IElementRepresentation value = new DoubleNumberRepresentation(1);
    	IElementRepresentation add = new AdditionRepresentation();
    	IElementRepresentation substract = new SubstractRepresentation();
    	IElementRepresentation value2 = new DoubleNumberRepresentation(1);
    	IElementRepresentation value3 = new DoubleNumberRepresentation(1);
    	INPUT.add(value);
    	INPUT.add(add);
    	INPUT.add(value2);
    	INPUT.add(substract);
    	INPUT.add(value3);
        try {
        	assertTrue(convertor.convert(INPUT) instanceof IBinaryOperator<?>);
            assertEquals(1, convertor.convert(INPUT).solve().doubleValue(), 0);
        } catch (WrongPrefixFormatError e) {
            fail();
        }
    }
    
    @Test
    public void shouldConvertAnAdditionOfTwoBinaryOperator() {
    	ArrayList<IElementRepresentation> INPUT = new ArrayList<>();
    	IElementRepresentation value = new DoubleNumberRepresentation(1);
    	IElementRepresentation add = new AdditionRepresentation();
    	IElementRepresentation substract = new SubstractRepresentation();
    	IElementRepresentation substract2 = new SubstractRepresentation();
    	IElementRepresentation value2 = new DoubleNumberRepresentation(1);
    	IElementRepresentation value3 = new DoubleNumberRepresentation(1);
    	IElementRepresentation value4 = new DoubleNumberRepresentation(1);
    	INPUT.add(value);
    	INPUT.add(substract);
    	INPUT.add(value2);
    	INPUT.add(add);
    	INPUT.add(value3);
    	INPUT.add(substract2);
    	INPUT.add(value4);
        try {
        	assertTrue(convertor.convert(INPUT) instanceof IBinaryOperator<?>);
            assertEquals(0, convertor.convert(INPUT).solve().doubleValue(), 0);
        } catch (WrongPrefixFormatError e) {
            fail();
        }
    }
}
