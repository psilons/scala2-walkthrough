package org.mytest.scala.walkthrough.utils

// AOP: https://github.com/FaKod/AOP-for-Scala

// http://biercoff.com/easily-measuring-code-execution-time-in-scala/
// https://newbedev.com/how-to-profile-methods-in-scala
object PerfUtils
{
    // mimic Python's timeit
    def timeit[R](func: => R, durUnit: String = "ns"): R = {
        val timer = new Timer(durUnit)
        val result = func
        println("time: " + timer.duration())
        result
    }
}

// This is to mimic python's context manager with new feature in 2.13
// Using ...
// https://github.com/scala/bug/issues/11459
import scala.util.Using.Releasable

object Timer {
  implicit val releasable: Releasable[Timer] = { timer =>
    println(timer.duration())
  }
}

// old way to do it - loan pattern
// https://alvinalexander.com/scala/how-to-open-read-text-files-in-scala-cookbook-examples/

// This idea is not working for multi context manager.
// For single context manager, see loan pattern in here
// https://alvinalexander.com/scala/how-to-open-read-text-files-in-scala-cookbook-examples/

// For multiple context manager, see: https://github.com/jsuereth/scala-arm
// https://stackoverflow.com/questions/8865754/scala-finally-block-closing-flushing-resource
// https://stackoverflow.com/questions/4604237/how-to-write-to-a-file-in-scala/34277491#34277491
// In scala 2.13, use the Using: https://stackoverflow.com/questions/57353702/cleaner-approach-for-quetly-closing-multiple-resources-in-scala


// implement Python's context manager for auto close
// https://www.pythontutorial.net/advanced-python/python-context-managers/

class Timer(durUnit: String = "ns", start: Long = System.nanoTime()) {
    def duration(): Double = {
        val end = System.nanoTime()
        val dur = end - start

        val res = durUnit match {
            case "hour" => dur.toDouble / 10e9 / 3600
            case "min" => dur.toDouble / 10e9 / 60
            case "sec" => dur.toDouble / 10e9
            case "ms" => dur.toDouble / 10e6
            case "us" => dur.toDouble / 10e3
            case _ => dur
        }

        res
    }
}


