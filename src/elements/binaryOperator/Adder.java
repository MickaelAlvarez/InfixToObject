package elements.binaryOperator;

import elements.number.INumber;
import elements.number.factory.NumberFactory;

public class Adder<C, T extends INumber<C>> implements IBinaryOperator<C> {
    private T leftOperand, rightOperand;

    public Adder(T leftOperand, T rightOperand) {
	this.leftOperand = leftOperand;
	this.rightOperand = rightOperand;
    }

    public Adder(IBinaryOperator<C> leftOperand, T rightOperand, NumberFactory<T, C> factory) {
	this.leftOperand = factory.create(leftOperand.solve());
	this.rightOperand = rightOperand;
    }
    
    public Adder(T leftOperand, IBinaryOperator<C> rightOperand, NumberFactory<T, C> factory) {
	this.leftOperand = leftOperand;
	this.rightOperand = factory.create(rightOperand.solve());
    }
    
    public Adder(IBinaryOperator<C> leftOperand, IBinaryOperator<C> rightOperand, NumberFactory<T, C> factory) {
	this.leftOperand = factory.create(leftOperand.solve());
	this.rightOperand = factory.create(rightOperand.solve());
    }

    @Override
    public C solve() {
	return leftOperand.add(rightOperand);
    }
}
