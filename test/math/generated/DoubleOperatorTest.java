package math.generated;

import static org.junit.Assert.*;

import org.junit.Test;

import fr.mickmouette.core.elements.IEquation;
import fr.mickmouette.math.generated.DoubleOperator;

public class DoubleOperatorTest {

    @Test
    public void DoubleNumbershouldReturnTheFloatValue() {
        IEquation<Double> value = new DoubleOperator(4d);
        assertEquals(4d, value.apply().doubleValue(), 0);
    }

}
