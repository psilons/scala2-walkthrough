package org.mytest.scala.walkthrough.s8_Implicits

// https://cwiki.apache.org/confluence/display/FLINK/Coding+Guidelines+for+Scala
// https://www.baeldung.com/scala/implicit-parameters

// hide database connections in DAO classes

// https://medium.com/@olxc/https-medium-com-olxc-implicits-in-scala-b2dcfccaa9e8
object ImplicitParameters extends App
{
    implicit val bob: String = "Bob"
    // we can't have more than 1 of same type within the scope, this fails
    // implicit val alice = "Alice"

    def greet(implicit name: String): Unit = {
      println(s"Hello, $name!")
    }

    // usage
    greet
}
