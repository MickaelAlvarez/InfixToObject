package fr.mickmouette.core.engine;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

import fr.mickmouette.core.elements.representation.IElementRepresentation;

/**
 * Convert from http://scanftree.com/Data_Structure/infix-to-prefix
 * 
 * @author Mickael Alvarez
 *
 */
public class InfixToPrefix<V> {

    public ArrayList<IElementRepresentation<V>> convert(ArrayList<IElementRepresentation<V>> infixEq) {
        Stack<IElementRepresentation<V>> stack = new Stack<IElementRepresentation<V>>();
        ArrayList<IElementRepresentation<V>> prefixedEq = new ArrayList<IElementRepresentation<V>>();
        ArrayList<IElementRepresentation<V>> reversedInfix = new ArrayList<IElementRepresentation<V>>(infixEq);
        Collections.reverse(reversedInfix);

        for (IElementRepresentation<V> element : reversedInfix) {
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
