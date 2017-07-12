package engine;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import elements.binaryOperator.Adder;
import elements.binaryOperator.Multiplier;
import elements.binaryOperator.Subtractor;
import elements.number.UnaryOperator;
import elements.representation.IElementRepresentation;
import elements.representation.number.DoubleNumberRepresentation;
import elements.representation.operator.AdditionRepresentation;
import elements.representation.operator.MultiplicationRepresentation;
import elements.representation.operator.SubstractRepresentation;
import engine.exception.WrongPrefixFormatError;

public class PrefixToObjectTest {
    private PrefixToObject<Double> convertor;

    @Before
    public void before() {
        convertor = new PrefixToObject<Double>();
    }

    @Test
    public void shouldConvertANumber() {
    	ArrayList<IElementRepresentation> INPUT = new ArrayList<>();
    	IElementRepresentation value = new DoubleNumberRepresentation(1d);
    	INPUT.add(value);
        try {
            assertTrue(convertor.convert(INPUT) instanceof UnaryOperator<?>);
            assertEquals(value.getDouble(), convertor.convert(INPUT).apply().doubleValue(), 0);
        } catch (WrongPrefixFormatError e) {
            fail();
        }

    }

    @Test
    public void shouldConvertAnOtherNumber() {
    	ArrayList<IElementRepresentation> INPUT = new ArrayList<>();
    	IElementRepresentation value = new DoubleNumberRepresentation(10d);
    	INPUT.add(value);
        try {
        	assertTrue(convertor.convert(INPUT) instanceof UnaryOperator<?>);
            assertEquals(value.getDouble(), convertor.convert(INPUT).apply().doubleValue(), 0);
        } catch (WrongPrefixFormatError e) {
            fail();
        }
    }
    
    /**
     * + 1 1
     */
    @Test
    public void shouldConvertAnAddition() {
    	ArrayList<IElementRepresentation> INPUT = new ArrayList<>();
    	IElementRepresentation value1 = new DoubleNumberRepresentation(1d);
    	IElementRepresentation addition = new AdditionRepresentation();
    	IElementRepresentation value2 = new DoubleNumberRepresentation(1d);
    	INPUT.add(addition);
    	INPUT.add(value1);
    	INPUT.add(value2);
        try {
        	assertTrue(convertor.convert(INPUT) instanceof Adder);
            assertEquals(2d, convertor.convert(INPUT).apply().doubleValue(), 0);
        } catch (WrongPrefixFormatError e) {
            fail();
        }
    }
    
    /**
     * + + 1 1 1
     */
    @Test
    public void shouldConvertTwoAddition() {
    	ArrayList<IElementRepresentation> INPUT = new ArrayList<>();
    	IElementRepresentation value1 = new DoubleNumberRepresentation(1d);
    	IElementRepresentation addition = new AdditionRepresentation();
    	INPUT.add(addition);
    	INPUT.add(addition);
    	INPUT.add(value1);
    	INPUT.add(value1);
    	INPUT.add(value1);
        try {
        	assertTrue(convertor.convert(INPUT) instanceof Adder);
            assertEquals(3d, convertor.convert(INPUT).apply().doubleValue(), 0);
        } catch (WrongPrefixFormatError e) {
            fail();
        }
    }
    
    /**
     * - 1 1
     */
    @Test
    public void shouldConvertASubstraction() {
    	ArrayList<IElementRepresentation> INPUT = new ArrayList<>();
    	IElementRepresentation value1 = new DoubleNumberRepresentation(1d);
    	IElementRepresentation substraction = new SubstractRepresentation();
    	IElementRepresentation value2 = new DoubleNumberRepresentation(1d);
    	INPUT.add(substraction);
    	INPUT.add(value1);
    	INPUT.add(value2);
        try {
        	assertTrue(convertor.convert(INPUT) instanceof Subtractor);
            assertEquals(0d, convertor.convert(INPUT).apply().doubleValue(), 0);
        } catch (WrongPrefixFormatError e) {
            fail();
        }
    }
    
    /**
     * * 1 1
     */
    @Test
    public void shouldConvertAMultiplication() {
    	ArrayList<IElementRepresentation> INPUT = new ArrayList<>();
    	IElementRepresentation value1 = new DoubleNumberRepresentation(2d);
    	IElementRepresentation multiplication = new MultiplicationRepresentation();
    	IElementRepresentation value2 = new DoubleNumberRepresentation(2d);
    	INPUT.add(multiplication);
    	INPUT.add(value1);
    	INPUT.add(value2);
        try {
        	assertTrue(convertor.convert(INPUT) instanceof Multiplier);
            assertEquals(4d, convertor.convert(INPUT).apply().doubleValue(), 0);
        } catch (WrongPrefixFormatError e) {
            fail();
        }
    }
    
    /**
     * 1 + 1
     */
    @Test
    public void wrongFormatShouldThrowAnError() {
    	ArrayList<IElementRepresentation> INPUT = new ArrayList<>();
    	IElementRepresentation value1 = new DoubleNumberRepresentation(1d);
    	IElementRepresentation addition = new AdditionRepresentation();
    	IElementRepresentation value2 = new DoubleNumberRepresentation(1d);
    	INPUT.add(value1);
    	INPUT.add(addition);
    	INPUT.add(value2);
        try {
            convertor.convert(INPUT);
            fail();
        } catch (WrongPrefixFormatError e) {
            // Should be thrown
        }
    }

}
