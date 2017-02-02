package engine;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import elements.number.INumber;
import elements.representation.IElementRepresentation;
import elements.representation.number.DoubleNumberRepresentation;
import engine.exception.WrongPrefixFormatError;

public class InfixConvertorTest {
    private InfixConvertor convertor;

    @Before
    public void before() {
        convertor = new InfixConvertor(new PrefixConvertor());
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
}
