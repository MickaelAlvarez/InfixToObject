package core.generated;

import static org.junit.Assert.*;

import org.junit.Test;

import fr.mickmouette.core.elements.IEquation;
import fr.mickmouette.core.elements.generated.UnaryOperator;
import fr.mickmouette.core.elements.generated.ValueOperator;

public class UnaryOperatorTest {

	@Test
	public void unaryOperatorCanBeAppliedOnValue() {
		// !true
		assertFalse(buildNotOperator(buildTrueValue()).apply());
	}
	
	@Test
	public void unaryOperatorCanBeAppliedOnOperator() {
		// !!true
		assertTrue(buildNotOperator(buildNotOperator(buildTrueValue())).apply());
	}
	
	private UnaryOperator<Boolean> buildNotOperator(IEquation<Boolean> operator) {
		return new UnaryOperator<Boolean>(operator) {
			@Override
			public Boolean apply() {
				return !operator.apply();
			}
		};
	}
	
	private ValueOperator<Boolean> buildTrueValue() {
		return new ValueOperator<Boolean>(true) {
			@Override
			public Boolean apply() {
				return value;
			}
		};
	}
}
