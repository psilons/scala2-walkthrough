package org.mytest.scala.walkthrough.S6_Functions

// use case: fixing function signature
// https://stackoverflow.com/questions/8063325/usefulness-as-in-practical-applications-of-currying-v-s-partial-application-i
// look for Martin Odersky

// https://www.vasinov.com/blog/on-currying-and-partial-function-application/

// implicit parameter
// https://dzone.com/articles/resolve-me-implicitly
object Currying extends App
{
    val add = (x: Int, y: Int) => x + y

    val add3 = add.curried(3)

    println(add3(7))

    // another way to define curry
    // https://www.baeldung.com/scala/currying
    def mulCurry(x: Int)(y: Int): Int = x * y
    val mul5: Int => Int = mulCurry(5)
    println(mul5(2))
    // see examples in the link for the need of curry
}
