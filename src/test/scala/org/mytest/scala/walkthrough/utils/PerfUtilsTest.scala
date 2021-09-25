package org.mytest.scala.walkthrough.utils

import org.mytest.scala.walkthrough.s1_DataTypes.NumbersUtil.countPrimes
import org.scalatest.flatspec.AnyFlatSpec

import scala.util.Using
import scala.io.Source

class PerfUtilsTest extends AnyFlatSpec
{
    "timeit" should "print out dur" in {
        println(PerfUtils.timeit(countPrimes(1000000)))
        PerfUtils.timeit(countPrimes(1000000), "us")
        PerfUtils.timeit(countPrimes(1000000), "ms")
        PerfUtils.timeit(countPrimes(1000000), "sec")
    }

    it should "print out duration" in {
        Using.resources(Source.fromFile("build.sbt"), new Timer()) { (file, timer) =>
            // check file open: sudo lsof -u Al | grep '/etc/passwd'
            println(file.getLines.mkString)
            println(timer.duration())
            println("---")
        }
    }
}
