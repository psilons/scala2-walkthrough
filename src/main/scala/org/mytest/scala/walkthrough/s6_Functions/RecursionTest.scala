package org.mytest.scala.walkthrough.s6_Functions

import scala.annotation.tailrec

object RecursionTest extends App
{
    def factorial(i: BigInt): BigInt = {
        if (i == 1)
            1
        else
            i * factorial(i-1)
    }

    println(factorial(20))

    @tailrec
    def factorial_tailrec(i: BigInt, prevRes: BigInt = 1): BigInt = {
        if (i == 1)
            prevRes
        else
            factorial_tailrec(i-1, i * prevRes)
    }

    println(factorial_tailrec(20))

    def fibonacci(i: BigInt): BigInt = {
        if (i <= 2) // make sure f(1) = f(2) = 1
            1
        else
            fibonacci(i-1) + fibonacci(i-2)
    }

    println(fibonacci(20))
}

