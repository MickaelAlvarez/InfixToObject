package engine;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Test;

import elements.representation.IElementRepresentation;
import elements.representation.number.DoubleNumberRepresentation;
import elements.representation.operator.AdditionRepresentation;
import elements.representation.operator.CloseParentheseRepresentation;
import elements.representation.operator.DivisionRepresentation;
import elements.representation.operator.MultiplicationRepresentation;
import elements.representation.operator.OpenParentheseRepresentation;
import elements.representation.operator.PowerRepresentation;
import elements.representation.operator.SubstractRepresentation;

public class InfixToPrefixTest {

	/**
     * INPUT = A
     * EXPECTED = A
     */
    @Test
    public void numberTest() {
    	ArrayList<IElementRepresentation> INPUT = new ArrayList<>();
        IElementRepresentation number = new DoubleNumberRepresentation(0);
        INPUT.add(number);
        assertEquals(INPUT, InfixToPrefix.convert(INPUT));
    }

    /**
     * INPUT = A + B
     * EXPECTED = + A B
     */
    @Test
    public void addTest() {
    	ArrayList<IElementRepresentation> INPUT = new ArrayList<>();
    	IElementRepresentation number1 = new DoubleNumberRepresentation(0);
    	IElementRepresentation number2 = new DoubleNumberRepresentation(0);
    	IElementRepresentation addition = new AdditionRepresentation();
    	INPUT.add(number1);
    	INPUT.add(addition);
    	INPUT.add(number2);
    	ArrayList<IElementRepresentation> EXPECTED = new ArrayList<>();
    	EXPECTED.add(addition);
    	EXPECTED.add(number1);
    	EXPECTED.add(number2);
        assertEquals(EXPECTED, InfixToPrefix.convert(INPUT));
    }

    /**
     * INPUT = A - B
     * EXPECTED = - A B
     */
    @Test
    public void substractTest() {
    	ArrayList<IElementRepresentation> INPUT = new ArrayList<>();
    	IElementRepresentation number1 = new DoubleNumberRepresentation(0);
    	IElementRepresentation number2 = new DoubleNumberRepresentation(0);
    	IElementRepresentation substraction = new SubstractRepresentation();
    	INPUT.add(number1);
    	INPUT.add(substraction);
    	INPUT.add(number2);
    	ArrayList<IElementRepresentation> EXPECTED = new ArrayList<>();
    	EXPECTED.add(substraction);
    	EXPECTED.add(number1);
    	EXPECTED.add(number2);
        assertEquals(EXPECTED, InfixToPrefix.convert(INPUT));
    }

    /**
     * INPUT = A * B
     * EXPECTED = * A B
     */
    @Test
    public void multiplyTest() {
    	ArrayList<IElementRepresentation> INPUT = new ArrayList<>();
    	IElementRepresentation number1 = new DoubleNumberRepresentation(0);
    	IElementRepresentation number2 = new DoubleNumberRepresentation(0);
    	IElementRepresentation multiplication = new SubstractRepresentation();
    	INPUT.add(number1);
    	INPUT.add(multiplication);
    	INPUT.add(number2);
    	ArrayList<IElementRepresentation> EXPECTED = new ArrayList<>();
    	EXPECTED.add(multiplication);
    	EXPECTED.add(number1);
    	EXPECTED.add(number2);
        assertEquals(EXPECTED, InfixToPrefix.convert(INPUT));
    }

    /**
     * INPUT = A / B
     * EXPECTED = / A B
     */
    @Test
    public void divideTest() {
    	ArrayList<IElementRepresentation> INPUT = new ArrayList<>();
    	IElementRepresentation number1 = new DoubleNumberRepresentation(0);
    	IElementRepresentation number2 = new DoubleNumberRepresentation(0);
    	IElementRepresentation division = new DivisionRepresentation();
    	INPUT.add(number1);
    	INPUT.add(division);
    	INPUT.add(number2);
    	ArrayList<IElementRepresentation> EXPECTED = new ArrayList<>();
    	EXPECTED.add(division);
    	EXPECTED.add(number1);
    	EXPECTED.add(number2);
        assertEquals(EXPECTED, InfixToPrefix.convert(INPUT));
    }

    /**
     * INPUT = A ^ B
     * EXPECTED = ^ A B
     */
    @Test
    public void powerTest() {
        ArrayList<IElementRepresentation> INPUT = new ArrayList<>();
    	IElementRepresentation number1 = new DoubleNumberRepresentation(0);
    	IElementRepresentation number2 = new DoubleNumberRepresentation(0);
    	IElementRepresentation power = new PowerRepresentation();
    	INPUT.add(number1);
    	INPUT.add(power);
    	INPUT.add(number2);
    	ArrayList<IElementRepresentation> EXPECTED = new ArrayList<>();
    	EXPECTED.add(power);
    	EXPECTED.add(number1);
    	EXPECTED.add(number2);
        assertEquals(EXPECTED, InfixToPrefix.convert(INPUT));
    }

    /**
     * INPUT = A * ( B + C )
     * EXPECT = * A + B C
     */
    @Test
    public void parenthesisTest() {
        ArrayList<IElementRepresentation> INPUT = new ArrayList<>();
    	IElementRepresentation number1 = new DoubleNumberRepresentation(0);
    	IElementRepresentation number2 = new DoubleNumberRepresentation(0);
    	IElementRepresentation number3 = new DoubleNumberRepresentation(0);
    	IElementRepresentation addition = new AdditionRepresentation();
    	IElementRepresentation multiplication = new MultiplicationRepresentation();
    	IElementRepresentation openParenthese = new OpenParentheseRepresentation();
    	IElementRepresentation closeParenthese = new CloseParentheseRepresentation();
    	INPUT.add(number1);
    	INPUT.add(multiplication);
    	INPUT.add(openParenthese);
    	INPUT.add(number2);
    	INPUT.add(addition);
    	INPUT.add(number3);
    	INPUT.add(closeParenthese);
    	ArrayList<IElementRepresentation> EXPECTED = new ArrayList<>();
    	EXPECTED.add(multiplication);
    	EXPECTED.add(number1);
    	EXPECTED.add(addition);
    	EXPECTED.add(number2);
    	EXPECTED.add(number3);
        assertEquals(EXPECTED, InfixToPrefix.convert(INPUT));
    }

    /**
     * INPUT = A ^ ( B * C - D / E + ( F - G ) * H )
     * EXPECT = ^ A - * B C + / D E * - F G H
     */
    @Test
    public void prioritiesTest() {
    	ArrayList<IElementRepresentation> INPUT = new ArrayList<>();
    	IElementRepresentation number1 = new DoubleNumberRepresentation(0);
    	IElementRepresentation number2 = new DoubleNumberRepresentation(0);
    	IElementRepresentation number3 = new DoubleNumberRepresentation(0);
    	IElementRepresentation number4 = new DoubleNumberRepresentation(0);
    	IElementRepresentation number5 = new DoubleNumberRepresentation(0);
    	IElementRepresentation number6 = new DoubleNumberRepresentation(0);
    	IElementRepresentation number7 = new DoubleNumberRepresentation(0);
    	IElementRepresentation number8 = new DoubleNumberRepresentation(0);
    	IElementRepresentation power = new PowerRepresentation();
    	IElementRepresentation openParenthese = new OpenParentheseRepresentation();
    	IElementRepresentation multiplication = new MultiplicationRepresentation();
    	IElementRepresentation substraction = new SubstractRepresentation();
    	IElementRepresentation division = new DivisionRepresentation();
    	IElementRepresentation addition = new AdditionRepresentation();
    	IElementRepresentation openParenthese2 = new OpenParentheseRepresentation();
    	IElementRepresentation substraction2 = new SubstractRepresentation();
    	IElementRepresentation closeParenthese2 = new CloseParentheseRepresentation();
    	IElementRepresentation multiplication2 = new MultiplicationRepresentation();
    	IElementRepresentation closeParenthese = new CloseParentheseRepresentation();
    	
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
    	ArrayList<IElementRepresentation> EXPECTED = new ArrayList<>();
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
    	
        assertEquals(EXPECTED, InfixToPrefix.convert(INPUT));
    }
}
