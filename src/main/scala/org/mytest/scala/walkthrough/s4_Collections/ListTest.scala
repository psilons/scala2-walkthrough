package org.mytest.scala.walkthrough.s4_Collections

object ListTest extends App
{
    // https://medium.com/@knoldus/scala-map-vs-flatmap-b5a33c169675
    val animals = List("Cat", "Dog", "Tiger")
    println(animals.map(name => name.toUpperCase()))
    println(animals.flatMap(name => name.toUpperCase())) // flat each element to a list
}
