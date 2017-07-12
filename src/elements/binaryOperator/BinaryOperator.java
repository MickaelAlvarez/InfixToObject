package elements.binaryOperator;

import elements.IEquation;

public abstract class BinaryOperator<C> implements IEquation<C> {
    protected IEquation<C> leftOperand, rightOperand;

    public BinaryOperator(IEquation<C> leftOperand, IEquation<C> rightOperand) {
        this.leftOperand = leftOperand;
        this.rightOperand = rightOperand;
    }
}
