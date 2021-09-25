package org.mytest.scala.walkthrough.s4_Collections

import scala.collection.mutable

object MapTest extends App
{
    // https://alvinalexander.com/scala/how-to-choose-map-implementation-class-sorted-scala-cookbook/
    // LinkedHashMap maintains insertion order.
    // ListMap maintains insertion opposite order.
    // scala.collection.SortedMap is sorted by keys

    // https://alvinalexander.com/scala/how-to-choose-map-implementation-class-sorted-scala-cookbook/
    val mapDefault = new mutable.LinkedHashMap[String, Int]().withDefaultValue(0)
    println(mapDefault("Nothing"))
    val mapDefault1 = new mutable.LinkedHashMap[String, List[Int]]().withDefaultValue(List())
    println(mapDefault1("Nothing"))

    val value = for(i <- 0 to 10; j <- 0 to 10) yield i -> j
    println(value)
    println(value.toMap)
}
