package engine;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

import elements.number.INumber;
import engine.exception.WrongPrefixFormatError;

public class PrefixConvertorTest {
    private PrefixConvertor convertor;
    
    @Before
    public void before() {
	convertor = new PrefixConvertor();
    }

    @Test
    public void shouldConvertANumber() {
	String value = "1";
	try {
	    assertTrue(convertor.convert(value) instanceof INumber<?>);
	    assertEquals(Integer.parseInt(value), convertor.convert(value).solve().intValue());
	} catch (WrongPrefixFormatError e) {
	    fail();
	}
	
    }

    @Test
    public void shouldConvertAnOtherNumber() {
	String value = "10";
	try {
	    assertTrue(convertor.convert(value) instanceof INumber<?>);
	    assertEquals(Integer.parseInt(value), convertor.convert(value).solve().intValue());
	} catch (WrongPrefixFormatError e) {
	    fail();
	}
    }

    @Test
    public void wrongFormatShouldThrowAnError() {
	String value = "1+1";
	
	try {
	    convertor.convert(value);
	    fail();
	} catch(WrongPrefixFormatError e) {
	    // Should be thrown
	}
    }

}
