package elements.number.factory;

import elements.number.NumberDouble;

public class NumberDoubleFactory implements INumberFactory<NumberDouble, Double> {

    @Override
    public NumberDouble create(Double param) {
        return new NumberDouble(param);
    }

}
