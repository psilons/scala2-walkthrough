package org.mytest.scala.walkthrough.s5_Classes

abstract class AbstractClass(var name: String) {
    def printName(): Unit // we need parenthesis since the return type is Unit
}

// name has no var, see https://www.oreilly.com/library/view/scala-cookbook/9781449340292/ch04s11.html
// or we use override var
class ConcreteClass(name: String) extends AbstractClass(name) {
    override def printName(): Unit = println(name) // override parent's method
}

object ConcreteClass {
    def apply(name: String): AbstractClass = { // this is a special method to make constructor a method.
        new ConcreteClass((name))
    }
}

object ClassTest extends App {
    val a = new ConcreteClass("abc") // constructor
    a.printName() // we need parenthesis since the return type is Unit

    val b = ConcreteClass("def") // call apply()
    b.printName()
}
