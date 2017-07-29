package core.engine;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mockito;

import fr.mickmouette.core.elements.representation.BinaryOperatorRepresentation;
import fr.mickmouette.core.elements.representation.BlockEndOperatorRepresentation;
import fr.mickmouette.core.elements.representation.BlockStartOperatorRepresentation;
import fr.mickmouette.core.elements.representation.IElementRepresentation;
import fr.mickmouette.core.elements.representation.ValueOperatorRepresentation;
import fr.mickmouette.core.engine.InfixToPrefix;

/**
 * @author Mick
 * 
 * Test the convertion of an infixed representation to a prefixed representation
 *
 * The folowing tests use the next commentary convention :
 *
 * V : Value
 * BOp : binary operator
 * BOp(i), i : priority of the operator 
 * Xy, y : element position (X can be V or BOp)
 * 
 * It's always :
 *  the infixed representation -> The prefixed representation
 * 
 */
public class InfixToPrefixTest {
	private static InfixToPrefix<Integer> convertor;
	private ArrayList<IElementRepresentation<Integer>> INPUT;
	
	@BeforeClass
	public static void setUpClass() {
		convertor = new InfixToPrefix<Integer>();
	}
	
	@Before
	public void setUp() {
		INPUT = new ArrayList<IElementRepresentation<Integer>>();
	}

	/**
	 * V -> V
	 */
	@SuppressWarnings("unchecked")
	@Test
	public void testValueOperator() {
		ValueOperatorRepresentation<Integer> value = Mockito.mock(ValueOperatorRepresentation.class);
		INPUT.add(value);
		assertEquals(value, convertor.convert(INPUT).get(0));
	}
	
	/**
	 * V1 BOp V2 -> BOp V1 V2
	 */
	@SuppressWarnings("unchecked")
	@Test
	public void testBinaryOperator() {
		BinaryOperatorRepresentation<Integer> binaryOperator = Mockito.mock(BinaryOperatorRepresentation.class);
		Mockito.when(binaryOperator.isOperator()).thenReturn(true);
		ValueOperatorRepresentation<Integer> value1 = Mockito.mock(ValueOperatorRepresentation.class);
		ValueOperatorRepresentation<Integer> value2 = Mockito.mock(ValueOperatorRepresentation.class);
		INPUT.add(value1);
		INPUT.add(binaryOperator);
		INPUT.add(value2);
		ArrayList<IElementRepresentation<Integer>> RESULT = convertor.convert(INPUT);
		assertEquals(binaryOperator, RESULT.get(0));
		assertEquals(value1, RESULT.get(1));
		assertEquals(value2, RESULT.get(2));
	}
	
	/**
	 * V1 BOp1(2) V2 BOp2(3) V3 -> BOp1(2) V1 BOp2(3) V2 V3
	 */
	@SuppressWarnings("unchecked")
	@Test
	public void testBinaryOperatorsWithDiffrentPriorities() {
		BinaryOperatorRepresentation<Integer> binaryOperator1 = Mockito.mock(BinaryOperatorRepresentation.class);
		Mockito.when(binaryOperator1.isOperator()).thenReturn(true);
		Mockito.when(binaryOperator1.getPriority()).thenReturn(2);
		BinaryOperatorRepresentation<Integer> binaryOperator2 = Mockito.mock(BinaryOperatorRepresentation.class);
		Mockito.when(binaryOperator2.isOperator()).thenReturn(true);
		Mockito.when(binaryOperator2.getPriority()).thenReturn(3);
		
		ValueOperatorRepresentation<Integer> value1 = Mockito.mock(ValueOperatorRepresentation.class);
		ValueOperatorRepresentation<Integer> value2 = Mockito.mock(ValueOperatorRepresentation.class);
		ValueOperatorRepresentation<Integer> value3 = Mockito.mock(ValueOperatorRepresentation.class);
		INPUT.add(value1);
		INPUT.add(binaryOperator1);
		INPUT.add(value2);
		INPUT.add(binaryOperator2);
		INPUT.add(value3);
		
		ArrayList<IElementRepresentation<Integer>> RESULT = convertor.convert(INPUT);
		assertEquals(binaryOperator1, RESULT.get(0));
		assertEquals(value1, RESULT.get(1));
		assertEquals(binaryOperator2, RESULT.get(2));
		assertEquals(value2, RESULT.get(3));
		assertEquals(value3, RESULT.get(4));
	}
	
	/**
	 * V1 BOp1 Po1 V2 BOp2 V3 Pc1 -> BOp1 BOp2 V2 V3 V1
	 */
	@SuppressWarnings("unchecked")
	@Test
	public void testBlockOperator() {
		BinaryOperatorRepresentation<Integer> binaryOperator1 = Mockito.mock(BinaryOperatorRepresentation.class);
		Mockito.when(binaryOperator1.isOperator()).thenReturn(true);
		BinaryOperatorRepresentation<Integer> binaryOperator2 = Mockito.mock(BinaryOperatorRepresentation.class);
		Mockito.when(binaryOperator2.isOperator()).thenReturn(true);
		BlockStartOperatorRepresentation<Integer> blockStart = Mockito.mock(BlockStartOperatorRepresentation.class);
		Mockito.when(blockStart.isOperator()).thenReturn(true);
		Mockito.when(blockStart.isBlockStart()).thenReturn(true);
		BlockEndOperatorRepresentation<Integer> blockEnd = Mockito.mock(BlockEndOperatorRepresentation.class);
		Mockito.when(blockEnd.isOperator()).thenReturn(true);
		Mockito.when(blockEnd.isBlockEnd()).thenReturn(true);
		
		ValueOperatorRepresentation<Integer> value1 = Mockito.mock(ValueOperatorRepresentation.class);
		ValueOperatorRepresentation<Integer> value2 = Mockito.mock(ValueOperatorRepresentation.class);
		ValueOperatorRepresentation<Integer> value3 = Mockito.mock(ValueOperatorRepresentation.class);
		INPUT.add(value1);
		INPUT.add(binaryOperator1);
		INPUT.add(blockStart);
		INPUT.add(value2);
		INPUT.add(binaryOperator2);
		INPUT.add(value3);
		INPUT.add(blockEnd);
		
		ArrayList<IElementRepresentation<Integer>> RESULT = convertor.convert(INPUT);
		assertEquals(binaryOperator1, RESULT.get(0));
		assertEquals(value1, RESULT.get(1));
		assertEquals(binaryOperator2, RESULT.get(2));
		assertEquals(value2, RESULT.get(3));
		assertEquals(value3, RESULT.get(4));
		// Check if blocks are deleted
		assertEquals(RESULT.size(), 5);
	}
	
}
