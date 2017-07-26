package fr.mickmouette.core.elements.representation;

import java.util.ArrayList;

import fr.mickmouette.core.elements.IElementBuilder;
import fr.mickmouette.core.elements.IEquation;
import fr.mickmouette.core.elements.exception.BuildBinaryOperatorException;
import fr.mickmouette.core.elements.exception.BuildBlockOperatorException;
import fr.mickmouette.core.elements.exception.BuildException;
import fr.mickmouette.core.elements.exception.BuildUnaryOperatorException;
import fr.mickmouette.core.elements.exception.BuildValueOperatorException;
import fr.mickmouette.core.elements.exception.convertion.ConvertionException;
import fr.mickmouette.core.elements.exception.convertion.ConvertUnaryOperatorException;
import fr.mickmouette.core.elements.generated.BinaryOperator;
import fr.mickmouette.core.elements.generated.UnaryOperator;
import fr.mickmouette.core.elements.generated.ValueOperator;

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
	public IEquation<T> convert(ArrayList<IElementRepresentation<T>> equation) throws BuildException, ConvertionException {
		if(equation == null || equation.isEmpty()) {
			throw new ConvertUnaryOperatorException();
		}
		
		return getBuilder().buildUnaryOperator(equation.get(0).convert(new ArrayList<>(equation.subList(1, equation.size()))));
	}

	@Override
	public IElementBuilder<T> getBuilder() throws BuildBlockOperatorException {
		return new IElementBuilder<T>() {

			@Override
			public ValueOperator<T> buildValueOperator() throws BuildValueOperatorException {
				throw new BuildValueOperatorException();
			}

			@Override
			public UnaryOperator<T> buildUnaryOperator(IEquation<T> eq) throws BuildUnaryOperatorException {
				return build(eq);
			}

			@Override
			public BinaryOperator<T> buildBinaryOperator(IEquation<T> leftEq, IEquation<T> rightEq)
					throws BuildBinaryOperatorException {
				throw new BuildBinaryOperatorException();
			}
		};
	}

}
