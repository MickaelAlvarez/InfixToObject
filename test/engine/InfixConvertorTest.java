package engine;

import static org.junit.Assert.*;

import org.junit.Test;

import elements.number.INumber;

public class InfixConvertorTest {

    @Test
    public void shouldConvertANumber() {
	String value = "1";
	InfixConvertor<Integer> convertor = new InfixConvertor<Integer>(value);
	assertTrue(convertor.convert() instanceof INumber<?>);
	assertEquals(Integer.parseInt(value), convertor.convert().solve().intValue());
    }

    @Test
    public void shouldConvertAnOtherNumber() {
	String value = "10";
	InfixConvertor<Integer> convertor = new InfixConvertor<Integer>(value);
	assertTrue(convertor.convert() instanceof INumber<?>);
	assertEquals(Integer.parseInt(value), convertor.convert().solve().intValue());
    }
}
