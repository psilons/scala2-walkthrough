package org.mytest.scala.walkthrough.s3_FlowControl

import org.mytest.scala.walkthrough.utils.PerfUtils

// https://www.theguardian.com/info/2021/oct/19/pondering-some-scala-performance-questions
object loop_test extends App
{
    def for_calc(p: Int) = {
        var result = 0
        for (
          a <- 3 to p;
          b <- 1 until ((p - a) / 2);
          c = p - (a + b)
        )
        {
            if(b * b + c * c == a * a)
                result += 1
        }
        result
    }

    println(PerfUtils.timeit((3 to 1000).maxBy(for_calc), "ms"))

    def for_calc1(p: Int) = { // fastest
        var result = 0
        for (a <- 3 to p)
        {
            for (b <- 1 until ((p - a) / 2)) {
                val c = p - (a + b)
                if(b * b + c * c == a * a)
                    result += 1
            }
        }
        result
    }

    println(PerfUtils.timeit((3 to 1000).maxBy(for_calc1), "ms"))

    def while_calc(p: Int) = {
        var (result, a) = (0, 3)
        while (a <= p) {
          var b = 1
          while (b < ((p - a) / 2)) {
            val c = p - (a + b)
            if (b * b + c * c == a * a)
              result += 1
              b += 1
          }
          a += 1
        }
        result
    }

    println(PerfUtils.timeit((3 to 1000).maxBy(while_calc), "ms"))
}
