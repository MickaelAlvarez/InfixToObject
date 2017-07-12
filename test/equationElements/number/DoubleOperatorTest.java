package equationElements.number;

import static org.junit.Assert.*;

import org.junit.Test;

import elements.IEquation;
import elements.number.DoubleOperator;

public class DoubleOperatorTest {

    @Test
    public void DoubleNumbershouldReturnTheFloatValue() {
        IEquation<Double> value = new DoubleOperator(4d);
        assertEquals(4d, value.apply().doubleValue(), 0);
    }

}
