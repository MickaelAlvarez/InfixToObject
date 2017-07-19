package math.generated;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import fr.mickmouette.core.elements.IEquation;
import fr.mickmouette.math.generated.Subtractor;

public class SubtractorDoubleOperatorTest {
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
	 * 1 = 2 - 1
	 */
    @Test
    public void subtractDoubleAndDoubleValuesTest() {
    	IEquation<Double> subtractor = new Subtractor(valueTwo, valueOne);
    	assertEquals(1, subtractor.apply().doubleValue(), 0);
    }

    /**
     * 1 = 2 - (2 - 1)
     */
    @Test
    public void subtractDoubleAndSubtractorValuesTest() {
    	IEquation<Double> rightOperand = new Subtractor(valueTwo, valueOne);
    	IEquation<Double> subtractor = new Subtractor(valueTwo, rightOperand);
        assertEquals(1, subtractor.apply().doubleValue(), 0);
    }

    /**
     * 0 = (2 - 1) - 1
     */
    @Test
    public void subtractSubtractorAndDoubleValuesTest() {
    	IEquation<Double> leftOperand = new Subtractor(valueTwo, valueOne);
    	IEquation<Double> subtractor = new Subtractor(leftOperand, valueOne);
        assertEquals(0, subtractor.apply().doubleValue(), 0);
    }

    /**
     * 0 = (2 - 1) - (2 - 1)
     */
    @Test
    public void addAdderAndAdderValuesTest() {
    	IEquation<Double> rightOperand = new Subtractor(valueTwo, valueOne);
    	IEquation<Double> leftOperand = new Subtractor(valueTwo, valueOne);
    	IEquation<Double> subtractor = new Subtractor(leftOperand, rightOperand);
        assertEquals(0, subtractor.apply().doubleValue(), 0);
    }

}
