package org.mytest.scala.walkthrough.s3_FlowControl

object S3_FlowControls extends App
{
    // https://baihuqian.github.io/2017-09-20-Scala-Flow-Control/

    // if then else
    val x = 5
    val step: Int = if(x > 0) 1 else -1 // without else, it returns ()

    if(step > 0)
        println("positive")
    else
        println("negative")

    // scala has no break built-in, so we have to work around it
    // for loop break

    import scala.util.control.Breaks.{break, breakable}

    var sum = 0
    breakable
    {
        for(i <- 0 to 100)
        {
            sum += i
            if(sum >= 10) break()
        }
    }
    println("sum = " + sum) // should be 10 = 1 + 2 + 3 + 4

    // 2nd way
    var sum1 = 0
    var done = false
    for(_ <- 0 to 100 if !done)
    {
        sum1 += 1
        if(sum1 >= 10) done = true
    }
    println("sum = " + sum1) // should be 10 = 1 + 2 + 3 + 4

    val range1 = 1 to 5 // inclusive, 1, 2, 3, 4, 5
    val range2 = 1 until 5 // exclusive, 1, 2, 3, 4
    val range3 = 1 to 5 by 2 // 1, 3, 5
    range1.foreach(println)


    // comprehension
    println(for(i <- 1 to 10) yield i * i)
    // or take action on each element
    val a: Seq[Int] = for(i <- 1 to 10) yield i * i
    a foreach println // one parameter can omit (), DSL

    // PS3E page 128, python context manager

    // pattern match
    // PS3E, page 139, chapter 4

    // lazy - run when needed, only once
}
