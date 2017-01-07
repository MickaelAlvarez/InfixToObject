package elements.number;

import elements.IEquation;

public interface INumber<T> extends IEquation<T> {
    public T getValue();

    public T add(INumber<T> other);

    public T multiply(INumber<T> other);

    public T substract(INumber<T> other);
}
