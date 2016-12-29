package elements.number;

public interface INumber<T> {
    public T getValue();
    public T add(INumber<T> other);
    public T multiply(INumber<T> other);
    public T substract(INumber<T> other);
}
