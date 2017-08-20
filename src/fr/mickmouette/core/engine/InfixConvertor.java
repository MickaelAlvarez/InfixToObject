package fr.mickmouette.core.engine;

import java.util.ArrayList;

import fr.mickmouette.core.Convertor;
import fr.mickmouette.core.elements.IEquation;
import fr.mickmouette.core.elements.exception.convertion.ConvertionException;
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
 * Transform an infixed formatted list of IElementRepresentation into an IEquation
 * 
 * @author Mickael Alvarez
 *
 * @param <V> the applied return type
 */
public class InfixConvertor<V> implements Convertor<V> {
    private PrefixToObject<V> convertor;

    public InfixConvertor(PrefixToObject<V> convertor) {
        this.convertor = convertor;
    }

    public IEquation<V> convert(ArrayList<IElementRepresentation<V>> equation) throws ConvertionException {
        return convertor.convert(new InfixToPrefix<V>().convert(equation));
    }

}
