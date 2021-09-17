# scala2-walkthrough

Scala docs: https://www.scala-lang.org/api/current/index.html#scala.math.Ordered

[sbt Introduction](sbt.md)

IntelliJ has Scala WorkSheet and Scala REPL

![repl](docs/scala_repl.png)

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

## Dependency Graph

https://www.baeldung.com/scala/sbt-dependency-tree


## Profiling
https://www.jetbrains.com/help/idea/java-flight-recorder.html#jfr-configurations
https://blog.jetbrains.com/idea/2020/03/profiling-tools-and-intellij-idea-ultimate/
https://bell-sw.com/announcements/2020/07/22/Hunting-down-code-hotspots-with-JDK-Flight-Recorder/
https://www.brendangregg.com/flamegraphs.html
https://medium.com/@muuki88/follow-the-stacktraces-jvm-performance-profiling-3c371d323e5f
https://users.scala-lang.org/t/how-to-profile-my-code/4752/9
https://stackoverflow.com/questions/9160001/how-to-profile-methods-in-scala

https://dev.to/frosnerd/microbenchmarking-your-scala-code-4885
https://github.com/scalameter/scalameter

https://medium.com/virtuslab/revisiting-scala-native-performance-67029089f241
book: Modern Systems Programming with Scala Native

https://medium.com/swlh/performance-test-on-an-api-using-gatling-85319ee32faa
https://alexandreesl.com/2020/02/12/gatling-making-performance-tests-with-scala/

https://scalac.io/blog/performance-testing/




## References
https://www.baeldung.com/scala/category/scala-basics

Images and links are from Amazon.

PiS4E: [Programming in Scala](https://www.amazon.com/Programming-Scala-Martin-Odersky/dp/098153161X) 

![pis4](docs/programming_in_scala_4E.jpg)

FPiS1E: [Functional Programming in Scala](https://www.amazon.com/Functional-Programming-Scala-Paul-Chiusano/dp/1617290653)

![fpis](docs/functional_programming_in_scala_1E.jpg)

SC1E: [Scala Cookbook](https://www.amazon.com/Scala-Cookbook-Object-Oriented-Functional-Programming/dp/1449339611)

![sc](docs/scala_cookbook_1E.jpg)
