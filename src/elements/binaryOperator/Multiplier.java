package elements.binaryOperator;

import elements.number.INumber;
import elements.number.factory.NumberFactory;

public class Multiplier<C, T extends INumber<C>> implements IBinaryOperator<C> {
    private T leftOperand, rightOperand;
    
    public Multiplier(T leftOperand, T rightOperand) {
	this.leftOperand = leftOperand;
	this.rightOperand = rightOperand;
    }
    
    public Multiplier(IBinaryOperator<C> leftOperand, T rightOperand, NumberFactory<T, C> factory) {
	this.leftOperand = factory.create(leftOperand.solve());
	this.rightOperand = rightOperand;
    }
    
    public Multiplier(T leftOperand, IBinaryOperator<C> rightOperand, NumberFactory<T, C> factory) {
	this.leftOperand = leftOperand;
	this.rightOperand = factory.create(rightOperand.solve());
    }
    
    public Multiplier(IBinaryOperator<C> leftOperand, IBinaryOperator<C> rightOperand, NumberFactory<T, C> factory) {
	this.leftOperand = factory.create(leftOperand.solve());
	this.rightOperand = factory.create(rightOperand.solve());
    }
    
    @Override
    public C solve() {
	return leftOperand.mul(rightOperand);
    }

}
