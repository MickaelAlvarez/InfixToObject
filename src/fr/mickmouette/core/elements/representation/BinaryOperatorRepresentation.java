package fr.mickmouette.core.elements.representation;


import fr.mickmouette.core.elements.IElementBuilder;
import fr.mickmouette.core.elements.IEquation;
import fr.mickmouette.core.elements.exception.BuildBinaryOperatorException;
import fr.mickmouette.core.elements.exception.BuildUnaryOperatorException;
import fr.mickmouette.core.elements.exception.BuildValueOperatorException;
import fr.mickmouette.core.elements.generated.BinaryOperator;
import fr.mickmouette.core.elements.generated.UnaryOperator;
import fr.mickmouette.core.elements.generated.ValueOperator;

public abstract class BinaryOperatorRepresentation<T> extends OperatorRepresentation<T> {
	protected abstract BinaryOperator<T> build(IEquation<T> leftEq, IEquation<T> rightEq);
	
	@Override
	public boolean isBlockStart() {
		return false;
	}
	
	@Override
	public boolean isBlockEnd() {
		return false;
	}
	
	@Override
	public IElementBuilder<T> getBuilder() {
		return new IElementBuilder<T>() {
			@Override
			public ValueOperator<T> buildValueOperator() throws BuildValueOperatorException {
				throw new BuildValueOperatorException();
			}

			@Override
			public BinaryOperator<T> buildBinaryOperator(IEquation<T> leftEq, IEquation<T> rightEq)
					throws BuildBinaryOperatorException {
				return build(leftEq, rightEq);
			}

			@Override
			public UnaryOperator<T> buildUnaryOpetor(IEquation<T> eq) throws BuildUnaryOperatorException {
				throw new BuildUnaryOperatorException();
			}
		};
	}
}
