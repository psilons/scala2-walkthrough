package org.mytest.scala.walkthrough.s1_DataTypes

import org.scalatest.flatspec.AnyFlatSpec

class NumbersUtilTest extends AnyFlatSpec {
    "check prime" should "return true for prime numbers" in {
        assert(NumbersUtil.checkPrime(2))
        assert(NumbersUtil.checkPrime(3))
        assert(NumbersUtil.checkPrime(5))
        assert(NumbersUtil.checkPrime(23))
        assert(NumbersUtil.checkPrime(101))
    }

    "check prime" should "return false for non prime numbers" in {
        assert(!NumbersUtil.checkPrime(1))
        assert(!NumbersUtil.checkPrime(4))
        assert(!NumbersUtil.checkPrime(6))
        assert(!NumbersUtil.checkPrime(25))
        assert(!NumbersUtil.checkPrime(34))
    }

    "count primes" should "return numbers of primes strictly smaller than give" in {
        assert(NumbersUtil.countPrimes(2) == 0)
        assert(NumbersUtil.countPrimes(3) == 1)
        assert(NumbersUtil.countPrimes(4) == 2)
        assert(NumbersUtil.countPrimes(5) == 2)
        assert(NumbersUtil.countPrimes(6) == 3)
        assert(NumbersUtil.countPrimes(7) == 3)
        assert(NumbersUtil.countPrimes(8) == 4)
        assert(NumbersUtil.countPrimes(9) == 4)
        assert(NumbersUtil.countPrimes(10) == 4)
        assert(NumbersUtil.countPrimes(11) == 4)
        assert(NumbersUtil.countPrimes(12) == 5)
    }
}
