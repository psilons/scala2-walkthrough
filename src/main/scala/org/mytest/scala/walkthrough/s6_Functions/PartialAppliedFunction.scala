package org.mytest.scala.walkthrough.s6_Functions

// This is different from partial functions
object PartialAppliedFunction extends App
{
    // PAF
    def linearFun(slope: Double, intersection: Double, x: Double): Double = {
        slope * x + intersection
    }

    val mylf = linearFun(2.0, 1, _)

    println(mylf(5))
    println(mylf(10))

    // partial function
    // https://stackoverflow.com/questions/8650549/using-partial-functions-in-scala-how-does-it-work/8650639#8650639
    val mySqrt: PartialFunction[Double, Double] = {
        case d if (d >= 0) => math.sqrt(d)
    }

    println(mySqrt.isDefinedAt(-1))
    println(mySqrt(3))
    println(List(0.5, -0.2, 4).collect(mySqrt))
}
