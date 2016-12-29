package elements.number.factory;

public interface NumberFactory<T, P> {
    public T create(P param);
}
