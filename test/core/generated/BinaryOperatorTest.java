package core.generated;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import core.generated.stubs.StubOperator;
import fr.mickmouette.core.elements.IEquation;
import fr.mickmouette.core.elements.generated.BinaryOperator;

public class BinaryOperatorTest {	
	
	@Test
	public void applyMethodShouldCallApplyOnBothOperators() {
		StubOperator leftOperator = new StubOperator();
		StubOperator rightOperator = new StubOperator();
		
		buildStandardBinaryOperator(leftOperator, rightOperator).apply();
		assertTrue(leftOperator.hasBeenCalled() && rightOperator.hasBeenCalled());
	}
	
	@Test
	public void applyMethodShouldCallApplyOnCombinedAndSimpleOperator() {
		StubOperator operator1 = new StubOperator();
		StubOperator operator2 = new StubOperator();
		StubOperator operator3 = new StubOperator();
		
		buildStandardBinaryOperator(buildStandardBinaryOperator(operator1, operator2), operator3).apply();
		assertTrue(operator1.hasBeenCalled() && operator2.hasBeenCalled() && operator3.hasBeenCalled());
	}
	
	@Test
	public void applyMethodShouldCallApplyOnSimpleOperatorAndCombinedOperator() {
		StubOperator operator1 = new StubOperator();
		StubOperator operator2 = new StubOperator();
		StubOperator operator3 = new StubOperator();
		
		buildStandardBinaryOperator(operator1, buildStandardBinaryOperator(operator2, operator3)).apply();
		assertTrue(operator1.hasBeenCalled() && operator2.hasBeenCalled() && operator3.hasBeenCalled());
	}
	
	@Test
	public void applyMethodShouldCallApplyOnCombinedOperatorAndCombinedOperator() {
		StubOperator operator1 = new StubOperator();
		StubOperator operator2 = new StubOperator();
		StubOperator operator3 = new StubOperator();
		StubOperator operator4 = new StubOperator();
		
		buildStandardBinaryOperator(buildStandardBinaryOperator(operator1, operator2), buildStandardBinaryOperator(operator3, operator4)).apply();
		assertTrue(operator1.hasBeenCalled() && operator2.hasBeenCalled() && operator3.hasBeenCalled() && operator4.hasBeenCalled());
	}
	
	private BinaryOperator<Void> buildStandardBinaryOperator(IEquation<Void> leftOperator, IEquation<Void> rightOperator) {
		return new BinaryOperator<Void>(leftOperator, rightOperator) {
			@Override
			public Void apply() {
				this.leftOperand.apply();
				this.rightOperand.apply();
				return null;
			}
		};
	}
}
