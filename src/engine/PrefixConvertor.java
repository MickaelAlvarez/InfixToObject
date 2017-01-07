package engine;

import elements.IEquation;
import elements.number.NumberDouble;
import engine.exception.WrongPrefixFormatError;

public class PrefixConvertor implements Convertor<Double> {

    public PrefixConvertor() {

    }

    public IEquation<Double> convert(String equation) throws WrongPrefixFormatError {
        if (InfixToPrefix.isOperator(equation.charAt(0))) {

        } else {
            int endNumberIndex = getEndNumberIndex(equation);

            if (endNumberIndex == equation.length()) {
                return new NumberDouble(Double.parseDouble(equation));
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
