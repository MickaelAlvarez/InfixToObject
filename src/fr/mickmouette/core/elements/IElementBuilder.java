package fr.mickmouette.core.elements;


import fr.mickmouette.core.elements.exception.BuildBinaryOperatorException;
import fr.mickmouette.core.elements.exception.BuildUnaryOperatorException;
import fr.mickmouette.core.elements.exception.BuildValueOperatorException;
import fr.mickmouette.core.elements.generated.BinaryOperator;
import fr.mickmouette.core.elements.generated.UnaryOperator;
import fr.mickmouette.core.elements.generated.ValueOperator;

public interface IElementBuilder<T> {
	ValueOperator<T> buildValueOperator() throws BuildValueOperatorException;
	UnaryOperator<T> buildUnaryOpetor(IEquation<T> eq) throws BuildUnaryOperatorException;
	BinaryOperator<T> buildBinaryOperator(IEquation<T> leftEq, IEquation<T> rightEq) throws BuildBinaryOperatorException;
}
