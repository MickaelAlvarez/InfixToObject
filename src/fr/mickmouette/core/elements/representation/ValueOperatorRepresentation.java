package fr.mickmouette.core.elements.representation;


import java.util.ArrayList;

import fr.mickmouette.core.elements.IElementBuilder;
import fr.mickmouette.core.elements.IEquation;
import fr.mickmouette.core.elements.exception.BuildBinaryOperatorException;
import fr.mickmouette.core.elements.exception.BuildException;
import fr.mickmouette.core.elements.exception.BuildUnaryOperatorException;
import fr.mickmouette.core.elements.exception.BuildValueOperatorException;
import fr.mickmouette.core.elements.exception.convertion.ConvertionException;
import fr.mickmouette.core.elements.exception.convertion.ConvertValueOperatorException;
import fr.mickmouette.core.elements.generated.BinaryOperator;
import fr.mickmouette.core.elements.generated.UnaryOperator;
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
	public IEquation<T> convert(ArrayList<IElementRepresentation<T>> equation) throws BuildException, ConvertionException {
		if(equation != null && !equation.isEmpty()) {
			throw new ConvertValueOperatorException();
		}
		return getBuilder().buildValueOperator();
	}
	
	@Override
	public IElementBuilder<T> getBuilder() {
		return new IElementBuilder<T>() {

			@Override
			public ValueOperator<T> buildValueOperator() throws BuildValueOperatorException {
				return build();
			}

			@Override
			public BinaryOperator<T> buildBinaryOperator(IEquation<T> leftEq, IEquation<T> rightEq)
					throws BuildBinaryOperatorException {
				throw new BuildBinaryOperatorException();
			}

			@Override
			public UnaryOperator<T> buildUnaryOperator(IEquation<T> eq) throws BuildUnaryOperatorException {
				throw new BuildUnaryOperatorException();
			}
			
		};
	}
}
