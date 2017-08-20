package fr.mickmouette.core.engine;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

import fr.mickmouette.core.elements.representation.IElementRepresentation;

/**
 *  This project is a library developed for java object developers. It provide a way to easily manipulate infix expressions with an object representation.
 *  Copyright (C) 2017  Mickael Alvarez
 *
 *  This program is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *
 *  This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *
 *  Contact : mickael.alvarez.93@gmail.com
 * 
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
