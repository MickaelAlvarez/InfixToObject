package fr.mickmouette.core.elements.representation;

import java.util.ArrayList;

import fr.mickmouette.core.elements.IEquation;
import fr.mickmouette.core.elements.exception.DontHaveAValueException;
import fr.mickmouette.core.elements.exception.convertion.ConvertionException;

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
 *  Contact : alvarez.mickael.93@gmail.com
 * 
 * @author Mickael Alvarez
 *
 * @param <V>
 */
public interface IElementRepresentation<V> {
	public boolean isOperator();
	public boolean isBlockStart();
	public boolean isBlockEnd();
	public V getValue() throws DontHaveAValueException;
	public int getPriority();
	public IEquation<V> convert(ArrayList<IElementRepresentation<V>> equation) throws ConvertionException;
}
