# InfixToObject
This project is a library developed for java object developers. It provide a way to easily manipulate infix expressions with an object representation.

To explain the goal, I will take a mathematical equation, which have an infix representation. 

## Example
Look at this equation *V = 1 + 41*, I will named it *E*, after hours of reflections we can found that the result is 42 :).

As you can see *E* is composed of values (*43* and *1*) and infix elements (*=*, *+*). The common way to solve this simple example, is to apply the add operator to *1* and *41*, and to assign the result to *V*.

*1 + 41*

In Object oriented development we can represent this part with an Object that take two value and add them like that 

```java
new Adder(new Value(1), new Value(41));
```
Where *Adder* is defined as follow

```java
class Adder {
	private Value left, right;
	
	Adder(Value left, Value right) {
		this.left = left;
		this.right = right;
	}
	
	public Value solve() {
		// TODO add left and right
	}

}

```

Where *solve()* is the application of the adder on the values, it would return 42 in this part.

Now lets call the return value *res*.

* *V = res*

We can represent as follow

```java
new Assigner(new Value(), res);
```

Where *Assigner* is defined as follow

```java
class Assigner {
	private Value left, right;
	
	Assigner(Value left, Value right) {
		this.left = left;
		this.right = right;
	}
	
	public void solve() {
		// TODO assign right to left
	}
}
```

The complete Object representation can be :

```java
Value v = new Value();
new Assigner(v, new Adder(new Value(1), new Value(42)));
```

## Global view
So the goal of this library is to transform

```
V = 1 + 41
```

To

```java
Value v = new Value();
new Assigner(v, new Adder(new Value(1), new Value(42)));
```

And give a way to recursively compute a custom treatment on all element of this expression. There it set V to 42.

## Why this project ?
### Why not ?
This project was not created to change the world, it just came to answer ordered questions I told to me : 
> How can we easily use polynomials equations in a java program ?

> Then, how can we easily manipulate an equation ?

> Then, as an equation is commonly represented in an infix way, how can we easily translate infix representation to an usable object version ?

So, I think I have to create this last brick (infix to object) to reach the first goal (polynomials equations).

### As generic as possible And MVC (Model View Controller)
This project is an opportunity to me to train my object architectural skills. 
On the one hand I tried to make it as clean as possible, and as generic as possible in order to make it usable as library. One the other hand I separated the representation of the generated object, to give the possibility to apply this library in a MVC template, there the representation object can directly be applied on the View.

### To train me to the TDD development
As important as the unit testing appear to me for an object oriented program, I tried to apply the TDD (Test Driven Development) principle.

## How it work
### Global view
![global view](https://raw.githubusercontent.com/MickaelAlvarez/InfixToObject/master/doc/main.svg)

You give a list of IElementRepresentation, which is directly the ordered infix expression elements from left to right that you want to treat. 

For example, with

*1 + 2*

You will give the list *{Value(1), Adder(), Value(2)}* where all this list members implements *IElementRepresentation*. Depending of your implementation of the *IElementRepresentation*, the generated IEquation expose you a way to recursively call a method named *apply()*.

The execution behavior must be include in this implementation, we will see next how it work.

### Engine
The engine come with the *InfixConvertor* class

![InfixConvertor](./doc/InfixConvertor.svg)

And the *InfixConvertor* is split in two parts

![InfixToPrefix & PrefixToObject](./doc/InfixToPrefix&PrefixToObject.svg)

* *PrefixToInfix* is the first step which reorder the prefixed list into an infix one, for example *1 + 2* will became *+ 1 2*

* *PrefixToObject* is the second step, it will construct the *IEquation* by recursively calling the *convert(ArrayList<IElementRepresentation<V>> equation)* method on each prefixed elements. There it will call first *convert()* on *+*, then the *IElementRepresentation* of *+* should itself call *convert()* on *1* and *2*.

## How to use it
There are five main *IElementRepresentation* abstract implementations
* *BlockStartOperatorRepresentation* and *BlockEndOperatorRepresentation*, which represents a group of infix elements, like parenthesis in equation
* *ValueOperatorRepresentation*, which represent a value, like an integer
* *UnaryOperatorRepresentation*, which represent a unary operator, like not (!) in logical expression
* *BinaryOperatorRepresentation*, which represent a binary operator, like addition

So you just have to override the elements representations you need, to use them like 

```java
List<IElementRepresentation<A>> infixValues; // there you put the infix representations
InfixConvertor<A> convertor = new InfixConvertor<A>(new PrefixToObject<A>());
IEquation<A> equation = convertor.convert(infixValues);
A result = equation.apply();
```

Where *A* is the type returned by your implementations of the *apply()* method.