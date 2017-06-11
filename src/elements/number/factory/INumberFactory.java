package elements.number.factory;

import elements.number.INumber;

public interface INumberFactory<T extends INumber<P>, P> {
    public T create(P param);
}
