package engine;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class InfixToPrefixTest {

    @Test
    public void numberTest() {
	String INPUT = "A";
	assertEquals("A", InfixToPrefix.convert(INPUT));
    }

    @Test
    public void addTest() {
	String INPUT = "A+B";
	assertEquals("+AB", InfixToPrefix.convert(INPUT));
    }

    @Test
    public void substractTest() {
	String INPUT = "A-B";
	assertEquals("-AB", InfixToPrefix.convert(INPUT));
    }

    @Test
    public void multiplyTest() {
	String INPUT = "A*B";
	assertEquals("*AB", InfixToPrefix.convert(INPUT));
    }

    @Test
    public void divideTest() {
	String INPUT = "A/B";
	assertEquals("/AB", InfixToPrefix.convert(INPUT));
    }

    @Test
    public void powerTest() {
	String INPUT = "A^B";
	assertEquals("^AB", InfixToPrefix.convert(INPUT));
    }

    @Test
    public void parenthesisTest() {
	String INPUT = "A*(B+C)";
	assertEquals("*A+BC", InfixToPrefix.convert(INPUT));
    }

    @Test
    public void prioritiesTest() {
	String INPUT = "A^(B*C-D/E+(F-G)*H)";
	assertEquals("^A-*BC+/DE*-FGH", InfixToPrefix.convert(INPUT));
    }
}
