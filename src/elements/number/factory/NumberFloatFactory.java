package elements.number.factory;

import elements.number.NumberFloat;

public class NumberFloatFactory implements INumberFactory<NumberFloat, Float> {

    @Override
    public NumberFloat create(Float param) {
        return new NumberFloat(param);
    }

}
