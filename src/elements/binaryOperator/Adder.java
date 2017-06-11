package elements.binaryOperator;

import elements.IEquation;
import elements.number.INumber;
import elements.number.factory.INumberFactory;

public class Adder<C, T extends INumber<C>> extends BinaryOperator<C, T> {

    public Adder(T leftOperand, T rightOperand) {
        super(leftOperand, rightOperand);
    }

    public Adder(IBinaryOperator<C> leftOperand, T rightOperand, INumberFactory<T, C> factory) {
        super(leftOperand, rightOperand, factory);
    }

    public Adder(T leftOperand, IBinaryOperator<C> rightOperand, INumberFactory<T, C> factory) {
        super(leftOperand, rightOperand, factory);
    }

    public Adder(IEquation<C> leftOperand, IEquation<C> rightOperand, INumberFactory<T, C> factory) {
        super(leftOperand, rightOperand, factory);
    }

    @Override
    public C solve() {
        return leftOperand.add(rightOperand);
    }
}
