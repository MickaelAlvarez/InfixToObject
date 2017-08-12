package fr.mickmouette.core.elements.representation;


import java.util.ArrayList;

import fr.mickmouette.core.elements.IEquation;
import fr.mickmouette.core.elements.exception.convertion.ConvertionException;
import fr.mickmouette.core.elements.exception.convertion.ConvertValueOperatorException;
import fr.mickmouette.core.elements.generated.ValueOperator;

public abstract class ValueOperatorRepresentation<T> implements IElementRepresentation<T> {
	protected T value;
	protected abstract ValueOperator<T> build();
	
	public ValueOperatorRepresentation(T value) {
		this.value = value;
	}
	
	@Override
	public boolean isOperator() {
		return false;
	}
	
	@Override
	public boolean isBlockStart() {
		return false;
	}
	
	@Override
	public boolean isBlockEnd() {
		return false;
	}

	@Override
	public int getPriority() {
		return 0;
	}
	
	@Override
	public IEquation<T> convert(ArrayList<IElementRepresentation<T>> equation) throws ConvertionException {
		if(equation != null && !equation.isEmpty()) {
			throw new ConvertValueOperatorException();
		}
		return build();
	}
}
