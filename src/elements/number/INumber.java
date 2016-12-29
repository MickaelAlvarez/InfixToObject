package elements.number;

public interface INumber<T> {
    public T getValue();
    public T add(INumber<T> other);
    public T mul(INumber<T> other);
}
