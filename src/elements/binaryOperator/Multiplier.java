package elements.binaryOperator;

import elements.IEquation;
import elements.number.INumber;
import elements.number.factory.NumberFactory;

public class Multiplier<C, T extends INumber<C>> extends BinaryOperator<C, T> {

    public Multiplier(T leftOperand, T rightOperand) {
        super(leftOperand, rightOperand);
    }

    public Multiplier(IBinaryOperator<C> leftOperand, T rightOperand, NumberFactory<T, C> factory) {
        super(leftOperand, rightOperand, factory);
    }

    public Multiplier(T leftOperand, IBinaryOperator<C> rightOperand, NumberFactory<T, C> factory) {
        super(leftOperand, rightOperand, factory);
    }

    public Multiplier(IEquation<C> leftOperand, IEquation<C> rightOperand, NumberFactory<T, C> factory) {
        super(leftOperand, rightOperand, factory);
    }

    @Override
    public C solve() {
        return leftOperand.multiply(rightOperand);
    }

}
