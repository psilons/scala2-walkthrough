package org.mytest.scala.walkthrough.s1_DataTypes

object NumbersUtil
{
    def checkPrime(num: Int): Boolean = num match {
        case n if n <= 1 => false
        case n if n <= 3 => true
        case _ =>
            val upTo = math.ceil(math.sqrt(num)).toInt
            for (i <- 2 to upTo)
                if (num % i == 0) return false
            true
    }

    // LC204 - return numbers of primes < num. Sieve of Eratosthenes
    def countPrimes(num: Int): Int = num match {
        case n if n <= 2 => 0 // there is no prime for < 2
        case n if n == 3 => 1 // 2 is the only prime < 3
        case _ =>
            // assume all primes initially, 0 -> num - 1
            val primeFlags = Array.fill[Int](num)(1) // 1 is used for sum
            primeFlags(0) = 0 // 0 is not a prime
            primeFlags(1) = 0 // 1 is not a prime
            val upTo = math.ceil(math.sqrt(num)).toInt
            for (i <- 2 to upTo) { // to includes right bound, until doesn't
                if (primeFlags(i) != 0)
                    for (j <- i*2 until num by i)
                        primeFlags(j) = 0
            }
            primeFlags.sum
    }
    // O(nlog(logn))
    // https://stackoverflow.com/questions/2582732/time-complexity-of-sieve-of-eratosthenes-algorithm
    // Here is an O(n) algo
    // https://www.codementor.io/@svenkatadileepkumar/find-all-the-prime-numbers-less-than-n-in-o-n-time-complexity-1amti1lm2p

}
