package elements.number.factory;

import elements.number.NumberInteger;

public class NumberIntegerFactory implements INumberFactory<NumberInteger, Integer> {

    @Override
    public NumberInteger create(Integer param) {
        return new NumberInteger(param);
    }

}
