package elements.binaryOperator;

import elements.IEquation;
import elements.number.INumber;
import elements.number.factory.NumberFactory;

public abstract class BinaryOperator<C, T extends INumber<C>> implements IBinaryOperator<C> {
    protected T leftOperand, rightOperand;

    public BinaryOperator(T leftOperand, T rightOperand) {
        this.leftOperand = leftOperand;
        this.rightOperand = rightOperand;
    }

    public BinaryOperator(IBinaryOperator<C> leftOperand, T rightOperand, NumberFactory<T, C> factory) {
        this.leftOperand = factory.create(leftOperand.solve());
        this.rightOperand = rightOperand;
    }

    public BinaryOperator(T leftOperand, IBinaryOperator<C> rightOperand, NumberFactory<T, C> factory) {
        this.leftOperand = leftOperand;
        this.rightOperand = factory.create(rightOperand.solve());
    }

    public BinaryOperator(IEquation<C> leftOperand, IEquation<C> rightOperand,
            NumberFactory<T, C> factory) {
        this.leftOperand = factory.create(leftOperand.solve());
        this.rightOperand = factory.create(rightOperand.solve());
    }
}
