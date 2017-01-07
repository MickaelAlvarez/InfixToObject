package engine;

import elements.IEquation;
import elements.number.NumberInteger;
import engine.exception.WrongPrefixFormatError;

public class PrefixConvertor implements Convertor<Integer> {

    public PrefixConvertor() {

    }

    public IEquation<Integer> convert(String equation) throws WrongPrefixFormatError {
        if (InfixToPrefix.isOperator(equation.charAt(0))) {

        } else {
            int endNumberIndex = getEndNumberIndex(equation);

            if (endNumberIndex == equation.length()) {
                return new NumberInteger(Integer.parseInt(equation));
            } else {
                throw new WrongPrefixFormatError(equation);
            }
        }

        return null;
    }

    private int getEndNumberIndex(String equation) {
        int endNumberIndex;

        for (endNumberIndex = 0; endNumberIndex < equation.length(); endNumberIndex++) {
            if (InfixToPrefix.isOperator(equation.charAt(endNumberIndex))) {
                break;
            }
        }

        return endNumberIndex;
    }

}
