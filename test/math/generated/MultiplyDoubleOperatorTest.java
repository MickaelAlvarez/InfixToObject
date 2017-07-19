package math.generated;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import fr.mickmouette.core.elements.IEquation;
import fr.mickmouette.math.generated.Multiplier;

public class MultiplyDoubleOperatorTest {
	private IEquation<Double> valueOne, valueTwo;
	
	@Before
	public void setUpValue() {
		valueOne = new IEquation<Double>() {
			@Override
			public Double apply() {
				return 1d;
			}
		};
		
		valueTwo = new IEquation<Double>() {
			@Override
			public Double apply() {
				return 2d;
			}
		};
	}
	
	/**
	 * 2 = 1 * 2
	 */
    @Test
    public void multiplyDoubleAndDoubleValuesTest() {
    	IEquation<Double> multiplier = new Multiplier(valueOne, valueTwo);
        assertEquals(2, multiplier.apply().doubleValue(), 0);
    }

    /**
     * 4 = 2 * (1 * 2)
     */
    @Test
    public void multiplyDoubleAndMultiplierValuesTest() {
    	IEquation<Double> rightOperand = new Multiplier(valueOne, valueTwo);
    	IEquation<Double> multiplier = new Multiplier(valueTwo, rightOperand);
        assertEquals(4, multiplier.apply().doubleValue(), 0);
    }

    /**
     * 4 = (2 * 1) * 2
     */
    @Test
    public void multiplyMultiplierAndDoubleValuesTest() {
    	IEquation<Double> leftOperand = new Multiplier(valueTwo, valueOne);
    	IEquation<Double> multiplier = new Multiplier(leftOperand, valueTwo);
        assertEquals(4, multiplier.apply().doubleValue(), 0);
    }

    /**
     * 2 = (1 * 1) * (1 * 2)
     */
    @Test
    public void multiplyMultiplierAndMultiplierValuesTest() {
    	IEquation<Double> rightOperand = new Multiplier(valueOne, valueTwo);
    	IEquation<Double> leftOperand = new Multiplier(valueOne, valueOne);
    	IEquation<Double> multiplier = new Multiplier(leftOperand, rightOperand);
        assertEquals(2, multiplier.apply().doubleValue(), 0);
    }

}
