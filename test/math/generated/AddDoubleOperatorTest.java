package math.generated;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import fr.mickmouette.core.elements.IEquation;
import fr.mickmouette.math.generated.Adder;

public class AddDoubleOperatorTest {
	private IEquation<Double> valueOne;
	
	@Before
	public void setUpValue() {
		valueOne = new IEquation<Double>() {
			@Override
			public Double apply() {
				return 1d;
			}
		};
	}

	/**
	 * 2 = 1 + 1
	 */
    @Test
    public void addDoubleAndDoubleValuesTest() {
        IEquation<Double> adder = new Adder(valueOne, valueOne);
        assertEquals(2, adder.apply().doubleValue(), 0);
    }

    /**
     * 3 = 1 + (1 + 1)
     */
    @Test
    public void addDoubleAndAdderValuesTest() {
        IEquation<Double> rightOperand = new Adder(valueOne, valueOne);
        IEquation<Double> adder = new Adder(valueOne, rightOperand);
        assertEquals(3, adder.apply().doubleValue(), 0);
    }

    /**
     * 3 = (1 + 1) + 1
     */
    @Test
    public void addAdderAndDoubleValuesTest() {
    	IEquation<Double> leftOperand = new Adder(valueOne, valueOne);
        IEquation<Double> adder = new Adder(leftOperand, valueOne);
        assertEquals(3, adder.apply().doubleValue(), 0);
    }

    /**
     * 4 = (1 + 1) + (1 + 1)
     */
    @Test
    public void addAdderAndAdderValuesTest() {
    	IEquation<Double> leftOperand = new Adder(valueOne, valueOne);
        IEquation<Double> rightOperand = new Adder(valueOne, valueOne);
        IEquation<Double> adder = new Adder(leftOperand, rightOperand);
        assertEquals(4, adder.apply().doubleValue(), 0);
    }

}
