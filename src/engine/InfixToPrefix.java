package engine;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

import elements.representation.IElementRepresentation;

/**
 * Convert from http://scanftree.com/Data_Structure/infix-to-prefix
 * 
 * @author mickmouette
 *
 */
public class InfixToPrefix {

    public static ArrayList<IElementRepresentation> convert(ArrayList<IElementRepresentation> infixEq) {
        Stack<IElementRepresentation> stack = new Stack<IElementRepresentation>();
        ArrayList<IElementRepresentation> prefixedEq = new ArrayList<IElementRepresentation>();
        ArrayList<IElementRepresentation> reversedInfix = new ArrayList<IElementRepresentation>(infixEq);
        Collections.reverse(reversedInfix);

        for (IElementRepresentation element : reversedInfix) {
            if (!element.isOperator()) {
            	prefixedEq.add(element);
            } else {
                if (element.isBlockEnd()) {
                    stack.push(element);
                } else if (element.isBlockStart()) {
                    while (!stack.lastElement().isBlockEnd()) {
                    	prefixedEq.add(stack.pop());
                    }
                    stack.pop();
                } else {
                    if (stack.isEmpty()) {
                        stack.push(element);
                    } else if (stack.lastElement().getPriority() <= element.getPriority()) {
                        stack.push(element);
                    } else {
                        while (!stack.isEmpty() && stack.lastElement().getPriority() >= element.getPriority()) {
                            prefixedEq.add(stack.pop());
                        }
                        stack.push(element);
                    }
                }
            }
        }

        while (!stack.isEmpty()) {
        	prefixedEq.add(stack.pop());
        }

        Collections.reverse(prefixedEq);
        return prefixedEq;
    }
    
}
