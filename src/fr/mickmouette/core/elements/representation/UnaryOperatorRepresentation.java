package fr.mickmouette.core.elements.representation;

import java.util.ArrayList;

import fr.mickmouette.core.elements.IEquation;
import fr.mickmouette.core.elements.exception.convertion.ConvertionException;
import fr.mickmouette.core.elements.exception.convertion.ConvertUnaryOperatorException;
import fr.mickmouette.core.elements.generated.UnaryOperator;

public abstract class UnaryOperatorRepresentation<T> extends OperatorRepresentation<T> {
	protected abstract UnaryOperator<T> build(IEquation<T> eq);
	
	@Override
	public boolean isBlockStart() {
		return false;
	}

	@Override
	public boolean isBlockEnd() {
		return false;
	}
	
	@Override
	public IEquation<T> convert(ArrayList<IElementRepresentation<T>> equation) throws ConvertionException {
		if(equation == null || equation.isEmpty()) {
			throw new ConvertUnaryOperatorException();
		}
		
		return build(equation.get(0).convert(new ArrayList<>(equation.subList(1, equation.size()))));
	}

}
