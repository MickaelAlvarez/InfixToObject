package core.generated.stubs;

import fr.mickmouette.core.elements.generated.ValueOperator;

public class StubStandardValueOperator extends ValueOperator<Boolean> {

	public StubStandardValueOperator(Boolean value) {
		super(value);
	}

	@Override
	public Boolean apply() {
		return this.value;
	}
	
	
}