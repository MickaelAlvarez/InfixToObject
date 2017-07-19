package core.generated;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import core.generated.stubs.StubStandardValueOperator;
import fr.mickmouette.core.elements.generated.ValueOperator;

public class ValueOperatorTest {

	@Test
	public void valueOperatorShouldReturnHisValue() {
		ValueOperator<Boolean> valueTrue = new StubStandardValueOperator(true);
		ValueOperator<Boolean> valueFalse = new StubStandardValueOperator(false);
		
		assertTrue(valueTrue.apply());
		assertFalse(valueFalse.apply());
	}
	
}
