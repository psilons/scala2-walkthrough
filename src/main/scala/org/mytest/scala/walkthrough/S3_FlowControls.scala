package org.mytest.scala.walkthrough

object S3_FlowControls
{
    def main(args: Array[String]): Unit = {} // every app needs a main()

    // https://baihuqian.github.io/2017-09-20-Scala-Flow-Control/

    // if then else
    val x = 5
    val step: Int = if (x > 0) 1 else -1 // without else, it returns ()

    if (step > 0)
        println("positive")
    else
        println("negative")

    // scala has no break built-in, so we have to work around it
    // for loop break
    import scala.util.control.Breaks.{breakable, break}
    var sum = 0
    breakable {
        for (i <- 0 to 100) {
            sum += i
            if (sum >= 10) break()
        }
    }
    println("sum = " + sum) // should be 10 = 1 + 2 + 3 + 4

    // 2nd way
    var sum1 = 0
    var done = false
    for (_ <- 0 to 100 if !done) {
        sum1 += 1
        if (sum1 >= 10) done = true
    }
    println("sum = " + sum1) // should be 10 = 1 + 2 + 3 + 4

    // comprehension
    println(for (i <- 1 to 10) yield i*i)
    // or take action on each element
    val a: Seq[Int] = for (i <- 1 to 10) yield i*i
    a foreach println // one parameter can omit (), DSL
}
