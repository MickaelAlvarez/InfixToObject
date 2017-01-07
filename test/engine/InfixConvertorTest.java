package engine;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import elements.number.INumber;
import engine.exception.WrongPrefixFormatError;

public class InfixConvertorTest {
    private InfixConvertor convertor;

    @Before
    public void before() {
        convertor = new InfixConvertor(new PrefixConvertor());
    }

    @Test
    public void shouldConvertANumber() {
        String value = "1";
        try {
            assertTrue(convertor.convert(value) instanceof INumber<?>);
            assertEquals(Double.parseDouble(value), convertor.convert(value).solve().doubleValue(), 0);
        } catch (WrongPrefixFormatError e) {
            fail();
        }

    }

    @Test
    public void shouldConvertAnOtherNumber() {
        String value = "10";
        try {
            assertTrue(convertor.convert(value) instanceof INumber<?>);
            assertEquals(Double.parseDouble(value), convertor.convert(value).solve().doubleValue(), 0);
        } catch (WrongPrefixFormatError e) {
            fail();
        }

    }
}
