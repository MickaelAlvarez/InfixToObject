package engine;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class InfixToPrefixTest {

    @Test
    public void numberTest() {
        String INPUT = "A";
        assertEquals(InfixToPrefix.SEPARATOR + "A", InfixToPrefix.convert(INPUT));
    }

    @Test
    public void addTest() {
        String INPUT = "A+B";
        assertEquals("+" + InfixToPrefix.SEPARATOR + "A" +  InfixToPrefix.SEPARATOR + "B", InfixToPrefix.convert(INPUT));
    }

    @Test
    public void substractTest() {
        String INPUT = "A-B";
        assertEquals("-" + InfixToPrefix.SEPARATOR + "A" + InfixToPrefix.SEPARATOR + "B", InfixToPrefix.convert(INPUT));
    }

    @Test
    public void multiplyTest() {
        String INPUT = "A*B";
        assertEquals("*" + InfixToPrefix.SEPARATOR + "A" + InfixToPrefix.SEPARATOR + "B", InfixToPrefix.convert(INPUT));
    }

    @Test
    public void divideTest() {
        String INPUT = "A/B";
        assertEquals("/" + InfixToPrefix.SEPARATOR + "A" + InfixToPrefix.SEPARATOR + "B", InfixToPrefix.convert(INPUT));
    }

    @Test
    public void powerTest() {
        String INPUT = "A^B";
        assertEquals("^" + InfixToPrefix.SEPARATOR + "A" + InfixToPrefix.SEPARATOR + "B", InfixToPrefix.convert(INPUT));
    }

    @Test
    public void parenthesisTest() {
        String INPUT = "A*(B+C)";
        // *A+BC
        assertEquals("*" + InfixToPrefix.SEPARATOR + "A" + InfixToPrefix.SEPARATOR + "+" + InfixToPrefix.SEPARATOR + "B" + InfixToPrefix.SEPARATOR + "C", InfixToPrefix.convert(INPUT));
    }

    @Test
    public void prioritiesTest() {
        String INPUT = "A^(B*C-D/E+(F-G)*H)";
        // ^A-*BC+/DE*-FGH
        assertEquals("^" + InfixToPrefix.SEPARATOR + "A" + InfixToPrefix.SEPARATOR + "-" 
        + InfixToPrefix.SEPARATOR + "*" + InfixToPrefix.SEPARATOR + "B" + InfixToPrefix.SEPARATOR + "C" 
        + InfixToPrefix.SEPARATOR + "+" + InfixToPrefix.SEPARATOR + "/" + InfixToPrefix.SEPARATOR + "D" 
        + InfixToPrefix.SEPARATOR + "E" + InfixToPrefix.SEPARATOR + "*" + InfixToPrefix.SEPARATOR + "-" 
        + InfixToPrefix.SEPARATOR + "F" + InfixToPrefix.SEPARATOR + "G" + InfixToPrefix.SEPARATOR + "H", InfixToPrefix.convert(INPUT));
    }
}
