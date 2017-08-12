# InfixToObject
This project is a library developed to java object developers. It provide a way to easily manipulate any [infix](http://localhost) expressions with an object representation.

To explain the goal, I will take a mathematical equation, which have an infix representation. 

## Example

Look at this equation *V = 1 + 41*, I will named it *E*, after hours of reflections we can found that the result is 42 :).

As you can see *E* is composed of values (*43*, *1*, *C*) and infix elements (*=*, *+*). The common way to solve this simple example, is to apply the add operator to *1* and *41*, and to assign the result to *V*.

* *1 + 41*

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
new Assigner(new Value(), new Adder(new Value(1), new Value(42)));
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

> Then, as an equation is commonly represented in an infix way, how can we easily translate infix representation to a usable object version ?

So, I think I have to create this last brick (infix to object) to reach the first goal (polynomials equations).

### As generic as possible And MVC (Model View Controller)
This project is an opportunity to me to train my object architectural skills. 
On the one hand I tried to make it as clean as possible, and as generic as possible in order to make it usable as library. One the other hand I separated the representation of the generated object, to give the possibility to apply this library in a MVC template, there the representation object can directly be applied on the View.

### To train me to the TDD development
As important as the unit testing appear to me for an object oriented program, I tried to apply the TDD (Test Driven Development) principle.

## How it work
// TODO UML

## How to use it
// TODO Code examples