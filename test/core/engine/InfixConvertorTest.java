package core.engine;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mockito;

import fr.mickmouette.core.elements.exception.BuildException;
import fr.mickmouette.core.elements.exception.convertion.ConvertionException;
import fr.mickmouette.core.elements.representation.IElementRepresentation;
import fr.mickmouette.core.engine.InfixConvertor;
import fr.mickmouette.core.engine.PrefixToObject;

public class InfixConvertorTest {
	private static PrefixToObject<Integer> prefixConvertor;
	private static InfixConvertor<Integer> convertor;
	private ArrayList<IElementRepresentation<Integer>> INPUT;
	
	@SuppressWarnings("unchecked")
	@BeforeClass
	public static void setUpClass() {
		prefixConvertor = Mockito.mock(PrefixToObject.class);
		convertor = new InfixConvertor<>(prefixConvertor);
	}
	
	@Before
	public void setUp() {
		INPUT = new ArrayList<IElementRepresentation<Integer>>();
	}
	
	@Test
	public void testPrefixConvertorIsCalled() {
		try {
			convertor.convert(INPUT);
			Mockito.verify(prefixConvertor, Mockito.times(1)).convert(INPUT);
		} catch (BuildException | ConvertionException e) {
			fail();
		}
	}
}
