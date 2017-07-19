package fr.mickmouette.core.elements.representation;

import fr.mickmouette.core.elements.IElementBuilder;
import fr.mickmouette.core.elements.IEquation;
import fr.mickmouette.core.elements.exception.BuildBinaryOperatorException;
import fr.mickmouette.core.elements.exception.BuildBlockOperatorException;
import fr.mickmouette.core.elements.exception.BuildUnaryOperatorException;
import fr.mickmouette.core.elements.exception.BuildValueOperatorException;
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
	public IElementBuilder<T> getBuilder() throws BuildBlockOperatorException {
		return new IElementBuilder<T>() {

			@Override
			public ValueOperator<T> buildValueOperator() throws BuildValueOperatorException {
				throw new BuildValueOperatorException();
			}

			@Override
			public UnaryOperator<T> buildUnaryOpetor(IEquation<T> eq) throws BuildUnaryOperatorException {
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
