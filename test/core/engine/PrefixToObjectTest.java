package core.engine;

import static org.junit.Assert.fail;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mockito;

import fr.mickmouette.core.elements.exception.convertion.ConvertionException;
import fr.mickmouette.core.elements.representation.IElementRepresentation;
import fr.mickmouette.core.engine.PrefixToObject;

public class PrefixToObjectTest {
	private static PrefixToObject<Integer> convertor;
	private ArrayList<IElementRepresentation<Integer>> INPUT;
	
	@BeforeClass
	public static void setUpClass() {
		convertor = new PrefixToObject<Integer>();
	}
	
	@Before
	public void setUp() {
		INPUT = new ArrayList<IElementRepresentation<Integer>>();
	}

	@SuppressWarnings("unchecked")
	@Test
	public void testFirstConvertCall() {
		IElementRepresentation<Integer> operator = Mockito.mock(IElementRepresentation.class);
		IElementRepresentation<Integer> operatorValue = Mockito.mock(IElementRepresentation.class);
		INPUT.add(operator);
		INPUT.add(operatorValue);
		
		try {
			convertor.convert(INPUT);
			Mockito.verify(operator, Mockito.times(1)).convert(new ArrayList<>(INPUT.subList(1, 2)));
		} catch (ConvertionException e) {
			fail();
		}
	}
}
