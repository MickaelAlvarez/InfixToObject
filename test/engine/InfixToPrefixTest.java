package engine;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Test;

import elements.representation.IElementRepresentation;
import elements.representation.number.DoubleNumberRepresentation;
import elements.representation.operator.AdditionRepresentation;
import elements.representation.operator.DivisionRepresentation;
import elements.representation.operator.MultiplicationRepresentation;
import elements.representation.operator.PowerRepresentation;
import elements.representation.operator.SubstractRepresentation;
import elements.representation.operator.block.CloseParentheseRepresentation;
import elements.representation.operator.block.OpenParentheseRepresentation;

public class InfixToPrefixTest {

	/**
     * INPUT = A
     * EXPECTED = A
     */
    @Test
    public void numberTest() {
    	ArrayList<IElementRepresentation<Double>> INPUT = new ArrayList<>();
        IElementRepresentation<Double> number = new DoubleNumberRepresentation(0d);
        INPUT.add(number);
        assertEquals(INPUT, new InfixToPrefix<Double>().convert(INPUT));
    }

    /**
     * INPUT = A + B
     * EXPECTED = + A B
     */
    @Test
    public void addTest() {
    	ArrayList<IElementRepresentation<Double>> INPUT = new ArrayList<>();
    	IElementRepresentation<Double> number1 = new DoubleNumberRepresentation(0d);
    	IElementRepresentation<Double> number2 = new DoubleNumberRepresentation(0d);
    	IElementRepresentation<Double> addition = new AdditionRepresentation();
    	INPUT.add(number1);
    	INPUT.add(addition);
    	INPUT.add(number2);
    	ArrayList<IElementRepresentation<Double>> EXPECTED = new ArrayList<>();
    	EXPECTED.add(addition);
    	EXPECTED.add(number1);
    	EXPECTED.add(number2);
        assertEquals(EXPECTED, new InfixToPrefix<Double>().convert(INPUT));
    }

    /**
     * INPUT = A - B
     * EXPECTED = - A B
     */
    @Test
    public void substractTest() {
    	ArrayList<IElementRepresentation<Double>> INPUT = new ArrayList<>();
    	IElementRepresentation<Double> number1 = new DoubleNumberRepresentation(0d);
    	IElementRepresentation<Double> number2 = new DoubleNumberRepresentation(0d);
    	IElementRepresentation<Double> substraction = new SubstractRepresentation();
    	INPUT.add(number1);
    	INPUT.add(substraction);
    	INPUT.add(number2);
    	ArrayList<IElementRepresentation<Double>> EXPECTED = new ArrayList<>();
    	EXPECTED.add(substraction);
    	EXPECTED.add(number1);
    	EXPECTED.add(number2);
        assertEquals(EXPECTED, new InfixToPrefix<Double>().convert(INPUT));
    }

    /**
     * INPUT = A * B
     * EXPECTED = * A B
     */
    @Test
    public void multiplyTest() {
    	ArrayList<IElementRepresentation<Double>> INPUT = new ArrayList<>();
    	IElementRepresentation<Double> number1 = new DoubleNumberRepresentation(0d);
    	IElementRepresentation<Double> number2 = new DoubleNumberRepresentation(0d);
    	IElementRepresentation<Double> multiplication = new SubstractRepresentation();
    	INPUT.add(number1);
    	INPUT.add(multiplication);
    	INPUT.add(number2);
    	ArrayList<IElementRepresentation<Double>> EXPECTED = new ArrayList<>();
    	EXPECTED.add(multiplication);
    	EXPECTED.add(number1);
    	EXPECTED.add(number2);
        assertEquals(EXPECTED, new InfixToPrefix<Double>().convert(INPUT));
    }

    /**
     * INPUT = A / B
     * EXPECTED = / A B
     */
    @Test
    public void divideTest() {
    	ArrayList<IElementRepresentation<Double>> INPUT = new ArrayList<>();
    	IElementRepresentation<Double> number1 = new DoubleNumberRepresentation(0d);
    	IElementRepresentation<Double> number2 = new DoubleNumberRepresentation(0d);
    	IElementRepresentation<Double> division = new DivisionRepresentation();
    	INPUT.add(number1);
    	INPUT.add(division);
    	INPUT.add(number2);
    	ArrayList<IElementRepresentation<Double>> EXPECTED = new ArrayList<>();
    	EXPECTED.add(division);
    	EXPECTED.add(number1);
    	EXPECTED.add(number2);
        assertEquals(EXPECTED, new InfixToPrefix<Double>().convert(INPUT));
    }

    /**
     * INPUT = A ^ B
     * EXPECTED = ^ A B
     */
    @Test
    public void powerTest() {
        ArrayList<IElementRepresentation<Double>> INPUT = new ArrayList<>();
    	IElementRepresentation<Double> number1 = new DoubleNumberRepresentation(0d);
    	IElementRepresentation<Double> number2 = new DoubleNumberRepresentation(0d);
    	IElementRepresentation<Double> power = new PowerRepresentation();
    	INPUT.add(number1);
    	INPUT.add(power);
    	INPUT.add(number2);
    	ArrayList<IElementRepresentation<Double>> EXPECTED = new ArrayList<>();
    	EXPECTED.add(power);
    	EXPECTED.add(number1);
    	EXPECTED.add(number2);
        assertEquals(EXPECTED, new InfixToPrefix<Double>().convert(INPUT));
    }

    /**
     * INPUT = A * ( B + C )
     * EXPECT = * A + B C
     */
    @Test
    public void parenthesisTest() {
        ArrayList<IElementRepresentation<Double>> INPUT = new ArrayList<>();
    	IElementRepresentation<Double> number1 = new DoubleNumberRepresentation(0d);
    	IElementRepresentation<Double> number2 = new DoubleNumberRepresentation(0d);
    	IElementRepresentation<Double> number3 = new DoubleNumberRepresentation(0d);
    	IElementRepresentation<Double> addition = new AdditionRepresentation();
    	IElementRepresentation<Double> multiplication = new MultiplicationRepresentation();
    	IElementRepresentation<Double> openParenthese = new OpenParentheseRepresentation<Double>();
    	IElementRepresentation<Double> closeParenthese = new CloseParentheseRepresentation<Double>();
    	INPUT.add(number1);
    	INPUT.add(multiplication);
    	INPUT.add(openParenthese);
    	INPUT.add(number2);
    	INPUT.add(addition);
    	INPUT.add(number3);
    	INPUT.add(closeParenthese);
    	ArrayList<IElementRepresentation<Double>> EXPECTED = new ArrayList<>();
    	EXPECTED.add(multiplication);
    	EXPECTED.add(number1);
    	EXPECTED.add(addition);
    	EXPECTED.add(number2);
    	EXPECTED.add(number3);
        assertEquals(EXPECTED, new InfixToPrefix<Double>().convert(INPUT));
    }

    /**
     * INPUT = A ^ ( B * C - D / E + ( F - G ) * H )
     * EXPECT = ^ A - * B C + / D E * - F G H
     */
    @Test
    public void prioritiesTest() {
    	ArrayList<IElementRepresentation<Double>> INPUT = new ArrayList<>();
    	IElementRepresentation<Double> number1 = new DoubleNumberRepresentation(0d);
    	IElementRepresentation<Double> number2 = new DoubleNumberRepresentation(0d);
    	IElementRepresentation<Double> number3 = new DoubleNumberRepresentation(0d);
    	IElementRepresentation<Double> number4 = new DoubleNumberRepresentation(0d);
    	IElementRepresentation<Double> number5 = new DoubleNumberRepresentation(0d);
    	IElementRepresentation<Double> number6 = new DoubleNumberRepresentation(0d);
    	IElementRepresentation<Double> number7 = new DoubleNumberRepresentation(0d);
    	IElementRepresentation<Double> number8 = new DoubleNumberRepresentation(0d);
    	IElementRepresentation<Double> power = new PowerRepresentation();
    	IElementRepresentation<Double> openParenthese = new OpenParentheseRepresentation<Double>();
    	IElementRepresentation<Double> multiplication = new MultiplicationRepresentation();
    	IElementRepresentation<Double> substraction = new SubstractRepresentation();
    	IElementRepresentation<Double> division = new DivisionRepresentation();
    	IElementRepresentation<Double> addition = new AdditionRepresentation();
    	IElementRepresentation<Double> openParenthese2 = new OpenParentheseRepresentation<Double>();
    	IElementRepresentation<Double> substraction2 = new SubstractRepresentation();
    	IElementRepresentation<Double> closeParenthese2 = new CloseParentheseRepresentation<Double>();
    	IElementRepresentation<Double> multiplication2 = new MultiplicationRepresentation();
    	IElementRepresentation<Double> closeParenthese = new CloseParentheseRepresentation<Double>();
    	
    	INPUT.add(number1);
    	INPUT.add(power);
    	INPUT.add(openParenthese);
    	INPUT.add(number2);
    	INPUT.add(multiplication);
    	INPUT.add(number3);
    	INPUT.add(substraction);
    	INPUT.add(number4);
    	INPUT.add(division);
    	INPUT.add(number5);
    	INPUT.add(addition);
    	INPUT.add(openParenthese2);
    	INPUT.add(number6);
    	INPUT.add(substraction2);
    	INPUT.add(number7);
    	INPUT.add(closeParenthese2);
    	INPUT.add(multiplication2);
    	INPUT.add(number8);
    	INPUT.add(closeParenthese);
    	ArrayList<IElementRepresentation<Double>> EXPECTED = new ArrayList<>();
    	EXPECTED.add(power);
    	EXPECTED.add(number1);
    	EXPECTED.add(substraction);
    	EXPECTED.add(multiplication);
    	EXPECTED.add(number2);
    	EXPECTED.add(number3);
    	EXPECTED.add(addition);
    	EXPECTED.add(division);
    	EXPECTED.add(number4);
    	EXPECTED.add(number5);
    	EXPECTED.add(multiplication2);
    	EXPECTED.add(substraction2);
    	EXPECTED.add(number6);
    	EXPECTED.add(number7);
    	EXPECTED.add(number8);
    	
        assertEquals(EXPECTED, new InfixToPrefix<Double>().convert(INPUT));
    }
}
