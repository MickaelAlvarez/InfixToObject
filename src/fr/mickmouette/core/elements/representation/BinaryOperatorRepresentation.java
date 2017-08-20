package fr.mickmouette.core.elements.representation;

import java.util.ArrayList;

import fr.mickmouette.core.elements.IEquation;
import fr.mickmouette.core.elements.exception.convertion.ConvertionException;
import fr.mickmouette.core.elements.exception.convertion.ConvertBinaryOperatorException;
import fr.mickmouette.core.elements.generated.BinaryOperator;

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
 * @author Mickael Alvarez
 *
 * @param <T>
 */
public abstract class BinaryOperatorRepresentation<T> extends OperatorRepresentation<T> {
	protected abstract BinaryOperator<T> build(IEquation<T> leftEq, IEquation<T> rightEq);
	
	@Override
	public boolean isBlockStart() {
		return false;
	}
	
	@Override
	public boolean isBlockEnd() {
		return false;
	}
	
	@Override
	public IEquation<T> convert(ArrayList<IElementRepresentation<T>> equation) throws ConvertionException {
		if(equation == null || equation.size() < 2) {
			throw new ConvertBinaryOperatorException();
		}
		
		int rightOperandStartIndex = getRightOperandStartIndex(equation);
		ArrayList<IElementRepresentation<T>> leftEquationRepresentation = new ArrayList<>(equation.subList(0, rightOperandStartIndex));
		ArrayList<IElementRepresentation<T>> rightEquationRepresentation = new ArrayList<>(equation.subList(rightOperandStartIndex, equation.size()));
		
		IEquation<T> leftEquation = leftEquationRepresentation.get(0).convert(new ArrayList<>(leftEquationRepresentation.subList(1, leftEquationRepresentation.size())));
		IEquation<T> rightEquation = rightEquationRepresentation.get(0).convert(new ArrayList<>(rightEquationRepresentation.subList(1, rightEquationRepresentation.size())));
		
		return build(leftEquation, rightEquation);
	}
	
	private int getRightOperandStartIndex(ArrayList<IElementRepresentation<T>> equation) {
		int index = 0, numberNeeded = 0;
		
		if(!equation.get(0).isOperator()) {
			return 1;
		} else {
			numberNeeded = 1;
			while(numberNeeded > 0) {
				if(equation.get(index).isOperator()) {
					numberNeeded ++;
				} else {
					numberNeeded --;
				}
				index++;
			}
		}
		
		return index;
	}
}
