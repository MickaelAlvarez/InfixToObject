package engine;

import elements.IEquation;
import elements.number.NumberInteger;

public class InfixConvertor<T> {
    private String equation;

    public InfixConvertor(String equation) {
	this.equation = equation;
    }

    public IEquation<Integer> convert() {
	return convert(equation);
    }

    private IEquation<Integer> convert(String equation) {
	int endNumberIndex = getEndNumberIndex(equation);
	
	if(endNumberIndex == equation.length()) {
	    return new NumberInteger(Integer.parseInt(equation));
	} else {
	    // TODO
	}
	
	return null;
    }

    private int getEndNumberIndex(String equation) {
	if (InfixToPrefix.isOperator(equation.charAt(0))) {
	    return -1;
	} else {
	    int endNumberIndex;

	    for (endNumberIndex = 0; endNumberIndex < equation.length(); endNumberIndex++) {
		if (InfixToPrefix.isOperator(equation.charAt(endNumberIndex))) {
		    break;
		}
	    }
	    
	    return endNumberIndex;
	}
    }
}
