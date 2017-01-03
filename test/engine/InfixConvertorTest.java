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
	assertEquals(1, convertor.convert().solve().intValue());
    }

}
