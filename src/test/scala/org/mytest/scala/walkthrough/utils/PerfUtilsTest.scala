package org.mytest.scala.walkthrough.utils

import org.mytest.scala.walkthrough.s1_DataTypes.NumbersUtil.countPrimes

import org.scalatest.flatspec.AnyFlatSpec

class PerfUtilsTest extends AnyFlatSpec
{
    it should "print out dur" in {
        println(PerfUtils.timeit(countPrimes(1000000)))
        PerfUtils.timeit(countPrimes(1000000), "us")
        PerfUtils.timeit(countPrimes(1000000), "ms")
        PerfUtils.timeit(countPrimes(1000000), "sec")
    }
}
