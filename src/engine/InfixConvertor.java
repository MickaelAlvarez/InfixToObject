package engine;

import elements.IEquation;
import elements.number.NumberInteger;

public class InfixConvertor<T> {
    private String equation;

    public InfixConvertor(String equation) {
	this.equation = equation;
    }
    
    public IEquation<Integer> convert() {
	return new NumberInteger(1);
    }
    
}
