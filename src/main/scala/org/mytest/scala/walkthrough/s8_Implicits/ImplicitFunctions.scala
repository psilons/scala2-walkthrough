package org.mytest.scala.walkthrough.s8_Implicits

import scala.language.implicitConversions

// https://medium.com/@olxc/https-medium-com-olxc-implicits-in-scala-b2dcfccaa9e8
object ImplicitFunctions extends App
{
    def implConv(): Unit = {
        implicit def intToStr(num: Int): String = s"The value is $num"

        // 42 -> "The value is 42" by intToStr -> "THE VALUE IS 42"
        println(42.toUpperCase())
    }
    implConv()

    def implExtra(): Unit = {
        case class StringOps(str: String) {
          def yell: String = str.toUpperCase() + "!"
          def isQuestion: Boolean = str.endsWith("?")
        }

        // enrich the class
        implicit def stringToStringOps(str: String): StringOps = StringOps(str)

        println("Hello world".yell) // evaluates to "HELLO WORLD!"
        println("How are you?".isQuestion) // evaluates to 'true'
    }
    implExtra()

    // impatient scala, P329
    // implicit conversion from T to Ordered[T]
    def smaller[T](a: T, b: T)(implicit order: T => Ordered[T]): T = if (order(a) < b) a else b

    println(smaller(40, 2))
}
