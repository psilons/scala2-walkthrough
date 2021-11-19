package org.mytest.scala.walkthrough.s4_Collections

object ListTest extends App
{
    // https://medium.com/@knoldus/scala-map-vs-flatmap-b5a33c169675
    val animals = List("Cat", "Dog", "Tiger")
    animals.foreach(println)

    for (a <- animals if a.startsWith("C")) println(a) // filter
    val d = for (a <- animals if a.toLowerCase().startsWith("d")) yield a // comprehension
    println(d)

    println(animals.map(name => name.toUpperCase()))
    println(animals.map(_.toLowerCase).mkString(" "))

    println(animals.flatMap(name => name.toUpperCase())) // flat each element to a list


    // tuple, different types, fixed length, 1 based index
    val tupleValues = ("Hello", 1, 2.3)
    println(tupleValues._1)
    //println(tupleValues(0)) // works only in Scala 3
    val (a, b, c) = tupleValues // unpack
    println(b)

    // Option, Some, None, Either

    val ints: List[String] = List("Cat", "Dog", "Tiger", "elephant")
    println(ints.sortWith(_.length() > _.length()).take(3))
}
