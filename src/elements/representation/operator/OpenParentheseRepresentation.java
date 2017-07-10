package elements.representation.operator;

import elements.IEquation;
import elements.binaryOperator.BinaryOperator;
import elements.number.INumber;
import elements.number.factory.INumberFactory;
import elements.representation.operator.block.BlockStartOperatorRepresentation;

public class OpenParentheseRepresentation<C, T extends INumber<C>> extends BlockStartOperatorRepresentation<C, T> {

	@Override
	public int getPriority() {
		return 1;
	}

	@Override
	public BinaryOperator<C, T> build(IEquation<C> leftEq, IEquation<C> rightEq, INumberFactory<T, C> factory) {
		// TODO Auto-generated method stub
		return null;
	}

}
