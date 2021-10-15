package org.mytest.scala.walkthrough.s1_DataTypes

object OptionComparison extends App {
  val a: Option[Float] = Option(.5f)
  val b = Option(0.7f)
  for {a1 <- a; b1 <- b}
    println(a1 <= b1)

  val c: Option[Float] = None
  val res = for {a1 <- a; c1 <- c} yield a1 <= c1
  println(res.getOrElse(a.exists(_ > 0.8)))
}
