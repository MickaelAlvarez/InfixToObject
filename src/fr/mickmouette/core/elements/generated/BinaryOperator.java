package fr.mickmouette.core.elements.generated;

import fr.mickmouette.core.elements.IEquation;

public abstract class BinaryOperator<C> implements IEquation<C> {
    protected IEquation<C> leftOperand, rightOperand;

    public BinaryOperator(IEquation<C> leftOperand, IEquation<C> rightOperand) {
        this.leftOperand = leftOperand;
        this.rightOperand = rightOperand;
    }
}
