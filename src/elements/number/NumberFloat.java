package elements.number;

public class NumberFloat implements INumber<Float> {
    private Float value;

    public NumberFloat(Float value) {
        this.value = value;
    }

    @Override
    public Float getValue() {
        return value;
    }

    @Override
    public Float add(INumber<Float> other) {
        return value + other.getValue();
    }

    @Override
    public Float multiply(INumber<Float> other) {
        return value * other.getValue();
    }

    @Override
    public Float substract(INumber<Float> other) {
        return value - other.getValue();
    }

    @Override
    public Float solve() {
        return getValue();
    }

}
