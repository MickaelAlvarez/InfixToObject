package core.generated.stubs;

import fr.mickmouette.core.elements.IEquation;

public class StubOperator implements IEquation<Void> {
	private boolean called;
	
	public StubOperator() {
		this.called = false;
	}
	
	@Override
	public Void apply() {
		called = true;
		return null;
	}
	
	public boolean hasBeenCalled() {
		return called;
	}
}
