package org.mytest.scala.walkthrough.utils

// http://biercoff.com/easily-measuring-code-execution-time-in-scala/
// https://newbedev.com/how-to-profile-methods-in-scala
object PerfUtils
{
    // mimic Python's timeit
    def timeit[R](func: => R, timeUnit: String = "ns"): R = {
        val start = System.nanoTime()
        val result = func
        val end = System.nanoTime()
        val dur = end - start

        val res = timeUnit match {
            case "hour" => dur.toDouble / 10e9 / 3600
            case "min" => dur.toDouble / 10e9 / 60
            case "sec" => dur.toDouble / 10e9
            case "ms" => dur.toDouble / 10e6
            case "us" => dur.toDouble / 10e3
            case _ => dur
        }
        println(s"spent $res $timeUnit")
        result
    }
}
