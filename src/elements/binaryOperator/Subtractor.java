package elements.binaryOperator;

import elements.IEquation;
import elements.number.INumber;
import elements.number.factory.INumberFactory;

public class Subtractor<C, T extends INumber<C>> extends BinaryOperator<C, T> {

    public Subtractor(T leftOperand, T rightOperand) {
        super(leftOperand, rightOperand);
    }

    public Subtractor(IBinaryOperator<C> leftOperand, T rightOperand, INumberFactory<T, C> factory) {
        super(leftOperand, rightOperand, factory);
    }

    public Subtractor(T leftOperand, IBinaryOperator<C> rightOperand, INumberFactory<T, C> factory) {
        super(leftOperand, rightOperand, factory);
    }

    public Subtractor(IEquation<C> leftOperand, IEquation<C> rightOperand, INumberFactory<T, C> factory) {
        super(leftOperand, rightOperand, factory);
    }

    @Override
    public C solve() {
        return leftOperand.substract(rightOperand);
    }

}
