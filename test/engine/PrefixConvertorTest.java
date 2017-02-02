package engine;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import elements.binaryOperator.Adder;
import elements.number.INumber;
import elements.representation.IElementRepresentation;
import elements.representation.number.DoubleNumberRepresentation;
import elements.representation.operator.AdditionRepresentation;
import engine.exception.WrongPrefixFormatError;

public class PrefixConvertorTest {
    private PrefixConvertor convertor;

    @Before
    public void before() {
        convertor = new PrefixConvertor();
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
    
    /**
     * + 1 1
     */
    @Test
    public void shouldConvertAnAddition() {
    	ArrayList<IElementRepresentation> INPUT = new ArrayList<>();
    	IElementRepresentation value1 = new DoubleNumberRepresentation(1);
    	IElementRepresentation addition = new AdditionRepresentation();
    	IElementRepresentation value2 = new DoubleNumberRepresentation(1);
    	INPUT.add(addition);
    	INPUT.add(value1);
    	INPUT.add(value2);
        try {
        	assertTrue(convertor.convert(INPUT) instanceof Adder);
            assertEquals(2d, convertor.convert(INPUT).solve().doubleValue(), 0);
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
    	IElementRepresentation value1 = new DoubleNumberRepresentation(1);
    	IElementRepresentation addition = new AdditionRepresentation();
    	INPUT.add(addition);
    	INPUT.add(addition);
    	INPUT.add(value1);
    	INPUT.add(value1);
    	INPUT.add(value1);
        try {
        	assertTrue(convertor.convert(INPUT) instanceof Adder);
            assertEquals(3d, convertor.convert(INPUT).solve().doubleValue(), 0);
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
    	IElementRepresentation value1 = new DoubleNumberRepresentation(1);
    	IElementRepresentation addition = new AdditionRepresentation();
    	IElementRepresentation value2 = new DoubleNumberRepresentation(1);
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
