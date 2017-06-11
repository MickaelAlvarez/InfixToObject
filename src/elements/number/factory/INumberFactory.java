package elements.number.factory;

public interface INumberFactory<T, P> {
    public T create(P param);
}
