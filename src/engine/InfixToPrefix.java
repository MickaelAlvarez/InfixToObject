package engine;

import java.util.Stack;

/**
 * Convert from
 * http://scanftree.com/Data_Structure/infix-to-prefix
 * @author mickmouette
 *
 */
public class InfixToPrefix {
    
    public static String convert(String infixEq) {
	Stack<Character> stack = new Stack<Character>();
	StringBuilder prefixedEq = new StringBuilder();
	String reversedInfix = new StringBuilder(infixEq).reverse().toString();

	for (char c : reversedInfix.toCharArray()) {
	    if (!isOperator(c)) {
		prefixedEq.append(c);
	    } else {
		if (c == ')') {
		    stack.push(c);
		} else if (c == '(') {
		    while (stack.lastElement() != ')') {
			prefixedEq.append(stack.pop());
		    }
		    stack.pop();
		} else {
		    if (stack.isEmpty()) {
			stack.push(c);
		    } else if (priority(stack.lastElement()) <= priority(c)) {
			stack.push(c);
		    } else {
			while (!stack.isEmpty() && priority(stack.lastElement()) >= priority(c)) {
			    prefixedEq.append(stack.pop());
			}
			stack.push(c);
		    }
		}
	    }
	}

	while (!stack.isEmpty()) {
	    prefixedEq.append(stack.pop());
	}

	return new StringBuilder(prefixedEq).reverse().toString();
    }

    private static int priority(char c) {
	switch (c) {
	case '(':
	case ')':
	    return 1;
	case '+':
	case '-':
	    return 2;
	case '*':
	case '/':
	    return 4;
	case '^':
	    return 6;
	default:
	    return 0;
	}
    }

    public static boolean isOperator(char c) {
	switch (c) {
	case '+':
	case '-':
	case '*':
	case '/':
	case '^':
	case '(':
	case ')':
	    return true;
	default:
	    return false;
	}
    }
}
