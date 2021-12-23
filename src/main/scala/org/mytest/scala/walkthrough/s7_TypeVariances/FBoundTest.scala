package org.mytest.scala.walkthrough.s7_TypeVariances

// https://twitter.github.io/scala_school/advanced-types.html#fbounded
// F- bounded test
trait Container[A <: Container[A]] extends Ordered[A]

// restrict the order to MyContainer objects only
class MyContainer extends Container[MyContainer] { def compare(that: MyContainer) = 0 }

// restrict the order to YourContainer objects only
class YourContainer extends Container[YourContainer] { def compare(that: YourContainer) = 0 }

object FBoundTest extends App
{
    val a = List(new MyContainer, new MyContainer, new MyContainer)
    println(a)
    println(a.min)

    val b = List(new MyContainer, new YourContainer)
    println(b)

    // we can't compare MyContainer with YourContainer because of the restriction on type in compare().
    //println(b.min)
}
