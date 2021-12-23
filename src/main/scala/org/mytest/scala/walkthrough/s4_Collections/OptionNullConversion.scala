package org.mytest.scala.walkthrough.s4_Collections

object OptionNullConversion extends App
{
    val a = "hello world"
    println(Option(a).map(x => Seq(x))) // List("hello world"),

    val b = null // null here
    println(Option(b).map(x => Seq(x))) // None(not Seq(null)), but no need to check null for b

    val c = List("here")
    a match
    {
        case c if c.nonEmpty => println("not null")
        case _ => println("oh oh")
    }

    case class Value(a: Int, b: List[String])

    val list = List(Value(1, List()), Value(2, List("ghi", "ijk")), Value(3, List("abc", "def")), Value(1, List("abc", "def")))

    val f = list.view.find(x => x.a == 1) // stop at first one
    println(f)

    val g = list.view.find(x => x.b.nonEmpty).map(x => x.b.head) // stop at first one
    println(g)
}
