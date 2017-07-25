package core.representation;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.ArrayList;

import org.junit.Test;
import org.mockito.Mockito;

import fr.mickmouette.core.elements.IEquation;
import fr.mickmouette.core.elements.exception.BuildException;
import fr.mickmouette.core.elements.exception.BuildValueOperatorException;
import fr.mickmouette.core.elements.exception.DontHaveAValueException;
import fr.mickmouette.core.elements.exception.convertion.OperandBinaryOperatorException;
import fr.mickmouette.core.elements.generated.BinaryOperator;
import fr.mickmouette.core.elements.generated.UnaryOperator;
import fr.mickmouette.core.elements.generated.ValueOperator;
import fr.mickmouette.core.elements.representation.BinaryOperatorRepresentation;
import fr.mickmouette.core.elements.representation.IElementRepresentation;
import fr.mickmouette.core.elements.representation.UnaryOperatorRepresentation;
import fr.mickmouette.core.elements.representation.ValueOperatorRepresentation;

public class ElementRepresentationConvertTest {

	@Test
	public void valueOperatorRepresentationShouldBeConvertedToValueOperator() {
		int VALUE = 123;
		
		ValueOperatorRepresentation<Integer> valueRepresentation = new ValueOperatorRepresentation<Integer>(VALUE) {
			@Override
			public Integer getValue() throws DontHaveAValueException {
				return this.value;
			}
			
			@Override
			protected ValueOperator<Integer> build() {
				return new ValueOperator<Integer>(this.value) {
					@Override
					public Integer apply() {
						return this.value;
					}
				};
			}
		};
		
		try {
			assertTrue(valueRepresentation.convert(null) instanceof ValueOperator<?>);
		} catch (BuildValueOperatorException e) {
			fail();
		}
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void valueOperatorRepresentationShouldNotHaveAConvertParameter() {
		ValueOperatorRepresentation<Integer> valueRepresentation = new ValueOperatorRepresentation<Integer>(null) {
			@Override
			public Integer getValue() throws DontHaveAValueException {
				return null;
			}
			
			@Override
			protected ValueOperator<Integer> build() {
				return new ValueOperator<Integer>(null) {
					@Override
					public Integer apply() {
						return null;
					}
				};
			}
		};
		
		ArrayList<IElementRepresentation<Integer>> operand = new ArrayList<>();
		operand.add(Mockito.mock(IElementRepresentation.class));
		
		try {
			valueRepresentation.convert(operand);
			fail();
		} catch (BuildValueOperatorException e) {
			// Should be thrown
		}
	}
	
	@Test
	public void unaryOperatorRepresentationShouldBeConvertedToAnUnaryOperator() {
		UnaryOperatorRepresentation<Void> representation = new UnaryOperatorRepresentation<Void>() {
			@Override
			public int getPriority() {
				return 0;
			}
			
			@Override
			protected UnaryOperator<Void> build(IEquation<Void> eq) {
				UnaryOperator<Void> operator = Mockito.mock(UnaryOperator.class);
				return operator;
			}
		};
		
		ArrayList<IElementRepresentation<Void>> eqs = new ArrayList<>();
		eqs.add(Mockito.mock(IElementRepresentation.class));
		
		try {
			assertTrue(representation.convert(eqs) instanceof UnaryOperator<?>);
		} catch (BuildException e) {
			fail();
		}
	}
	
	@Test
	public void unaryOperatorRepresentationShouldNotConvertANullEquation() {
		UnaryOperatorRepresentation<Void> representation = new UnaryOperatorRepresentation<Void>() {
			@Override
			public int getPriority() {
				return 0;
			}
			
			@Override
			protected UnaryOperator<Void> build(IEquation<Void> eq) {
				UnaryOperator<Void> operator = Mockito.mock(UnaryOperator.class);
				return operator;
			}
		};
		
		try {
			representation.convert(null);
			fail();
		} catch (BuildException e) {
			// Should be thrown
		}
	}
	
	@Test
	public void unaryOperatorRepresentationShouldNotConvertAnEmptyEquation() {
		UnaryOperatorRepresentation<Void> representation = new UnaryOperatorRepresentation<Void>() {
			@Override
			public int getPriority() {
				return 0;
			}
			
			@Override
			protected UnaryOperator<Void> build(IEquation<Void> eq) {
				UnaryOperator<Void> operator = Mockito.mock(UnaryOperator.class);
				return operator;
			}
		};
		
		try {
			representation.convert(new ArrayList<>());
			fail();
		} catch (BuildException e) {
			// Should be thrown
		}
	}
	
	@Test
	@SuppressWarnings("unchecked")
	public void unaryOperatorRepresentationShouldCallConvertOnHisOperator() {
		UnaryOperatorRepresentation<Void> representation = new UnaryOperatorRepresentation<Void>() {
			@Override
			public int getPriority() {
				return 0;
			}
			
			@Override
			protected UnaryOperator<Void> build(IEquation<Void> eq) {
				UnaryOperator<Void> operator = Mockito.mock(UnaryOperator.class);
				return operator;
			}
		};
		
		
		IElementRepresentation<Void> operand = Mockito.mock(IElementRepresentation.class);
		ArrayList<IElementRepresentation<Void>> eqs = new ArrayList<>();
		eqs.add(operand);
		
		try {
			representation.convert(eqs);
		} catch (BuildException e) {
			fail();
		}
		
		try {
			Mockito.verify(operand, Mockito.times(1)).convert(new ArrayList<>());
		} catch (BuildException e) {
			e.printStackTrace();
		}
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void binaryOperatorRepresentationShouldBeConvertedToABinaryOperator() {
		BinaryOperatorRepresentation<Void> representation = new BinaryOperatorRepresentation<Void>() {
			@Override
			public int getPriority() {
				return 0;
			}
			
			@Override
			protected BinaryOperator<Void> build(IEquation<Void> leftEq, IEquation<Void> rightEq) {
				BinaryOperator<Void> operator = Mockito.mock(BinaryOperator.class);
				return operator;
			}
		};
		
		IElementRepresentation<Void> element = Mockito.mock(IElementRepresentation.class);
		ArrayList<IElementRepresentation<Void>> eqs = new ArrayList<>();
		eqs.add(element);
		eqs.add(element);
		
		try {
			assertTrue(representation.convert(eqs) instanceof BinaryOperator<?>);
		} catch (BuildException e) {
			fail();
		}
	}
	
	@Test
	public void binaryOperatorRepresentationShouldNotConvertANullEquation() {
		BinaryOperatorRepresentation<Void> representation = new BinaryOperatorRepresentation<Void>() {
			@Override
			public int getPriority() {
				return 0;
			}

			@SuppressWarnings("unchecked")
			@Override
			protected BinaryOperator<Void> build(IEquation<Void> leftEq, IEquation<Void> rightEq) {
				return Mockito.mock(BinaryOperator.class);
			}
		};
		
		try {
			representation.convert(null);
			fail();
		} catch (OperandBinaryOperatorException e) {
			// Should be thrown
		} catch (BuildException e) {
			fail();
		}
	}
	
	@Test
	public void binaryOperatorRepresentationShouldNotConvertAUniqueElement() {
		BinaryOperatorRepresentation<Void> representation = new BinaryOperatorRepresentation<Void>() {
			@Override
			public int getPriority() {
				return 0;
			}

			@SuppressWarnings("unchecked")
			@Override
			protected BinaryOperator<Void> build(IEquation<Void> leftEq, IEquation<Void> rightEq) {
				return Mockito.mock(BinaryOperator.class);
			}
			
		};
		
		IElementRepresentation<Void> element = Mockito.mock(IElementRepresentation.class);
		ArrayList<IElementRepresentation<Void>> eqs = new ArrayList<>();
		eqs.add(element);
		
		try {
			representation.convert(eqs);
			fail();
		} catch (BuildException e) {
			// Should be thrown
		}
	}
	
	@Test
	@SuppressWarnings("unchecked")
	public void binaryOperatorRepresentationShouldCallConvertOnHisOperators() {
		BinaryOperatorRepresentation<Void> representation = new BinaryOperatorRepresentation<Void>() {
			@Override
			public int getPriority() {
				return 0;
			}

			@Override
			protected BinaryOperator<Void> build(IEquation<Void> leftEq, IEquation<Void> rightEq) {
				return Mockito.mock(BinaryOperator.class);
			}
		};
		
		
		IElementRepresentation<Void> operand = Mockito.mock(IElementRepresentation.class);
		ArrayList<IElementRepresentation<Void>> eqs = new ArrayList<>();
		eqs.add(operand);
		eqs.add(operand);
		
		try {
			representation.convert(eqs);
		} catch (BuildException e) {
			fail();
		}
		
		try {
			Mockito.verify(operand, Mockito.times(2)).convert(new ArrayList<>());
		} catch (BuildException e) {
			e.printStackTrace();
		}
	}
}
