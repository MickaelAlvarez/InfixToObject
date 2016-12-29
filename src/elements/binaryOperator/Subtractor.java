package elements.binaryOperator;

import elements.number.INumber;
import elements.number.factory.NumberFactory;

public class Subtractor<C, T extends INumber<C>> extends BinaryOperator<C, T> {

	public Subtractor(T leftOperand, T rightOperand) {
		super(leftOperand, rightOperand);
	}
	
	public Subtractor(IBinaryOperator<C> leftOperand, T rightOperand, NumberFactory<T, C> factory) {
		super(leftOperand, rightOperand, factory);
	}
	
	public Subtractor(T leftOperand, IBinaryOperator<C> rightOperand, NumberFactory<T, C> factory) {
		super(leftOperand, rightOperand, factory);
	}
	
	public Subtractor(IBinaryOperator<C> leftOperand, IBinaryOperator<C> rightOperand, NumberFactory<T, C> factory) {
		super(leftOperand, rightOperand, factory);
	}

	@Override
	public C solve() {
		return leftOperand.substract(rightOperand);
	}

}
