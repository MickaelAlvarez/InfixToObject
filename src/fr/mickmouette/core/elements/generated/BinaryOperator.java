package fr.mickmouette.core.elements.generated;

import fr.mickmouette.core.elements.IEquation;

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
 * @param <C>
 */
public abstract class BinaryOperator<C> implements IEquation<C> {
    protected IEquation<C> leftOperand, rightOperand;

    public BinaryOperator(IEquation<C> leftOperand, IEquation<C> rightOperand) {
        this.leftOperand = leftOperand;
        this.rightOperand = rightOperand;
    }
}
