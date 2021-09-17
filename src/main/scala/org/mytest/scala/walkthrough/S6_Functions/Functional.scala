package org.mytest.scala.walkthrough.S6_Functions

import scala.io.Source

object Functional extends App  // another way to run app, without main
{
    List(1, 2, 3).foreach(println) // print 1, 2, 3

    // https://alvinalexander.com/scala/fp-book/recursion-great-but-fold-reduce-in-scala/
    println( List(1, 2, 3).reduce((x, y) => x * y + 1) ) // 10, order is not predictable
    println( List(1, 2, 3).reduceLeft((x, y) => x * y + 1) ) // from left to right
    println( List(1, 2, 3).reduceRight((x, y) => x * y + 1) ) // right to left

    println( List(1, 2, 3).fold(100)((x, y) => x * y + 1) )

    // find max length of lines in a file
//    val lines: Iterator[String] = Source.fromFile("build.sbt").getLines()
//    lines.reduce((x, y) => x max y)
}
