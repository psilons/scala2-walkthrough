# scala2-walkthrough
Scala docs: https://www.scala-lang.org/api/current/index.html#scala.math.Ordered

## sbt Build tool
Download from: https://www.scala-sbt.org/index.html
Unzip the zip file and add the path to the PATH variable.

to get sbt version
```
sbt -v
```
to get Scala version (Scala version is controlled by the build file)
```
sbt scalaVersion
```
or
```
sbt "print scalaVersion"
```
To get Scala console
```
sbt console
```
(type in :q to quit). 

IntelliJ has Scala WorkSheet and Scala REPL

![repl](docs/scala_repl.png)

For other usage, see
```sbt help``` or see the [sbt doc](https://www.scala-sbt.org/1.x/docs/)

## Built-in Data Types
[Code Examples](src/main/scala/org/mytest/scala/walkthrough/S1_BuiltInDataTypes.scala)
explains the details.

Here is the entire Scala Type system

![built-in](docs/unified-types-diagram.svg)

## Strings
println(s"($i, $j)")

## Operators
From here: https://www.tutorialspoint.com/scala/scala_operators.htm

Arithmetic Operators: + - * / %

Bitwise Operators: & | ^ ~ << >> >>>

Boolean Operators: && || !

Relational Operators: == != > >= < <=

Assignment Operators: = += -= *= /= %= &= |= ^= <<= >>=

Precedence

Category 	Operator 	Associativity  
Postfix 	() [] 	Left to right  
Unary 	! ~ 	Right to left  
Multiplicative 	* / % 	Left to right  
Additive 	+ - 	Left to right  
Shift 	>> >>> << 	Left to right  
Relational 	> >= < <= 	Left to right  
Equality 	== != 	Left to right  
Bitwise AND 	& 	Left to right  
Bitwise XOR 	^ 	Left to right  
Bitwise OR 	| 	Left to right  
Logical AND 	&& 	Left to right  
Logical OR 	|| 	Left to right  
Assignment 	= += -= *= /= %= >>= <<= &= ^= |= 	Right to left  
Comma 	, 	Left to right  

## Flow Controls

[Types of Types](https://ktoso.github.io/scala-types-of-types/)

[An Introduction to Type Classes in Scala](https://medium.com/decisionbrain/an-introduction-to-type-classes-in-scala-790069926d07)

https://baihuqian.github.io/tags/#Scala

## Collections
https://www.jesperdj.com/2015/11/22/the-magic-of-for-yield-with-scala-collections/

## References
Images and links are from Amazon.

PiS4E: [Programming in Scala](https://www.amazon.com/Programming-Scala-Martin-Odersky/dp/098153161X) 

![pis4](docs/programming_in_scala_4E.jpg)

FPiS1E: [Functional Programming in Scala](https://www.amazon.com/Functional-Programming-Scala-Paul-Chiusano/dp/1617290653)

![fpis](docs/functional_programming_in_scala_1E.jpg)

SC1E: [Scala Cookbook](https://www.amazon.com/Scala-Cookbook-Object-Oriented-Functional-Programming/dp/1449339611)

![sc](docs/scala_cookbook_1E.jpg)
