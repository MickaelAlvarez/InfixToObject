package elements.binaryOperator;

import elements.IEquation;

public interface IBinaryOperator<C> extends IEquation<C> {
    public C solve();
}
