package elements.number.factory;

import elements.number.NumberFloat;

public class NumberFloatFactory implements NumberFactory<NumberFloat, Float> {

	@Override
	public NumberFloat create(Float param) {
		return new NumberFloat(param);
	}

}
