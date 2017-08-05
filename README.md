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
Creation of an Object version of an infix equation, in order to apply a TDD development and to train to have an architecture as clean as possible.
### Why not ?
### As generic as possible
### To train me to the TDD development

## How it work

## How to use it