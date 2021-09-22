package org.mytest.scala.walkthrough.s4_Collections

import org.scalatest.flatspec.AnyFlatSpec

class ListOfBooleansTest extends AnyFlatSpec
{
    val l1 = List(true, true, true)
    val l2 = List(true, true, false)
    val l3 = List(true, false, true)
    val l4 = List(true, false, false)
    val l5 = List(false, true, true)
    val l6 = List(false, true, false)
    val l7 = List(false, false, true)
    val l8 = List(false, false, false)

    "1st approach test" should "work" in {
        assert(ListOfBooleans1.matchAll(l1))
        assert(!ListOfBooleans1.matchAll(l2))
        assert(!ListOfBooleans1.matchAll(l3))
        assert(!ListOfBooleans1.matchAll(l4))
        assert(!ListOfBooleans1.matchAll(l5))
        assert(!ListOfBooleans1.matchAll(l6))
        assert(!ListOfBooleans1.matchAll(l7))
        assert(!ListOfBooleans1.matchAll(l8))

        assert(ListOfBooleans1.matchAny(l1))
        assert(ListOfBooleans1.matchAny(l2))
        assert(ListOfBooleans1.matchAny(l3))
        assert(ListOfBooleans1.matchAny(l4))
        assert(ListOfBooleans1.matchAny(l5))
        assert(ListOfBooleans1.matchAny(l6))
        assert(ListOfBooleans1.matchAny(l7))
        assert(!ListOfBooleans1.matchAny(l8))
    }

    "2nd approach test" should "work" in {
        assert(ListOfBooleans2.matchAll(l1))
        assert(!ListOfBooleans2.matchAll(l2))
        assert(!ListOfBooleans2.matchAll(l3))
        assert(!ListOfBooleans2.matchAll(l4))
        assert(!ListOfBooleans2.matchAll(l5))
        assert(!ListOfBooleans2.matchAll(l6))
        assert(!ListOfBooleans2.matchAll(l7))
        assert(!ListOfBooleans2.matchAll(l8))

        assert(ListOfBooleans2.matchAny(l1))
        assert(ListOfBooleans2.matchAny(l2))
        assert(ListOfBooleans2.matchAny(l3))
        assert(ListOfBooleans2.matchAny(l4))
        assert(ListOfBooleans2.matchAny(l5))
        assert(ListOfBooleans2.matchAny(l6))
        assert(ListOfBooleans2.matchAny(l7))
        assert(!ListOfBooleans2.matchAny(l8))
    }

    "3rd approach test" should "work" in {
        assert(ListOfBooleans3.matchAll(l1))
        assert(!ListOfBooleans3.matchAll(l2))
        assert(!ListOfBooleans3.matchAll(l3))
        assert(!ListOfBooleans3.matchAll(l4))
        assert(!ListOfBooleans3.matchAll(l5))
        assert(!ListOfBooleans3.matchAll(l6))
        assert(!ListOfBooleans3.matchAll(l7))
        assert(!ListOfBooleans3.matchAll(l8))

        assert(ListOfBooleans3.matchAny(l1))
        assert(ListOfBooleans3.matchAny(l2))
        assert(ListOfBooleans3.matchAny(l3))
        assert(ListOfBooleans3.matchAny(l4))
        assert(ListOfBooleans3.matchAny(l5))
        assert(ListOfBooleans3.matchAny(l6))
        assert(ListOfBooleans3.matchAny(l7))
        assert(!ListOfBooleans3.matchAny(l8))
    }

    "4th approach test" should "work" in {
        assert(ListOfBooleans4.matchAll(l1))
        assert(!ListOfBooleans4.matchAll(l2))
        assert(!ListOfBooleans4.matchAll(l3))
        assert(!ListOfBooleans4.matchAll(l4))
        assert(!ListOfBooleans4.matchAll(l5))
        assert(!ListOfBooleans4.matchAll(l6))
        assert(!ListOfBooleans4.matchAll(l7))
        assert(!ListOfBooleans4.matchAll(l8))

        assert(ListOfBooleans4.matchAny(l1))
        assert(ListOfBooleans4.matchAny(l2))
        assert(ListOfBooleans4.matchAny(l3))
        assert(ListOfBooleans4.matchAny(l4))
        assert(ListOfBooleans4.matchAny(l5))
        assert(ListOfBooleans4.matchAny(l6))
        assert(ListOfBooleans4.matchAny(l7))
        assert(!ListOfBooleans4.matchAny(l8))
    }

    "5th approach test" should "work" in {
        assert(ListOfBooleans5.matchAll(l1))
        assert(!ListOfBooleans5.matchAll(l2))
        assert(!ListOfBooleans5.matchAll(l3))
        assert(!ListOfBooleans5.matchAll(l4))
        assert(!ListOfBooleans5.matchAll(l5))
        assert(!ListOfBooleans5.matchAll(l6))
        assert(!ListOfBooleans5.matchAll(l7))
        assert(!ListOfBooleans5.matchAll(l8))

        assert(ListOfBooleans5.matchAny(l1))
        assert(ListOfBooleans5.matchAny(l2))
        assert(ListOfBooleans5.matchAny(l3))
        assert(ListOfBooleans5.matchAny(l4))
        assert(ListOfBooleans5.matchAny(l5))
        assert(ListOfBooleans5.matchAny(l6))
        assert(ListOfBooleans5.matchAny(l7))
        assert(!ListOfBooleans5.matchAny(l8))
    }

    // performance testing
    val size = 1000000
    val iters = 100
    val fullTrue: Seq[Boolean] = List.fill(size)(true)
    val fullFalse: Seq[Boolean] = List.fill(size)(false)

    val firstFalse: Seq[Boolean] = List(false) ++ List.fill(size-1)(true)
    val lastFalse: Seq[Boolean] = List.fill(size-1)(true) ++ List(false)

    val firstTrue:Seq[Boolean] = List(true) ++ List.fill(size-1)(false)
    val lastTrue:Seq[Boolean] = List.fill(size-1)(false) ++ List(true)

    "comp matchAll" should "be faster, but not" in {
        var start = 0L
        var total = 0d

        start = System.nanoTime()
        ListOfBooleans1.matchAll(fullTrue)
        total = (System.nanoTime() - start) /10e3
        println(s"ListOfBooleans1.matchAll(fullTrue): ${total} μs")

        start = System.nanoTime()
        ListOfBooleans5.matchAll(fullTrue)
        total = (System.nanoTime() - start) /10e3
        println(s"ListOfBooleans5.matchAll(fullTrue): ${total} μs")

        start = System.nanoTime()
        ListOfBooleans1.matchAll(fullFalse)
        total = (System.nanoTime() - start) /10e3
        println(s"ListOfBooleans1.matchAll(fullFalse): ${total} μs")

        start = System.nanoTime()
        ListOfBooleans5.matchAll(fullFalse)
        total = (System.nanoTime() - start) /10e3
        println(s"ListOfBooleans5.matchAll(fullFalse): ${total} μs")

        start = System.nanoTime()
        ListOfBooleans1.matchAll(firstFalse)
        total = (System.nanoTime() - start) /10e3
        println(s"ListOfBooleans1.matchAll(firstFalse): ${total} μs")

        start = System.nanoTime()
        ListOfBooleans5.matchAll(firstFalse)
        total = (System.nanoTime() - start) /10e3
        println(s"ListOfBooleans5.matchAll(firstFalse): ${total} μs")

        start = System.nanoTime()
        ListOfBooleans1.matchAll(lastFalse)
        total = (System.nanoTime() - start) /10e3
        println(s"ListOfBooleans1.matchAll(lastFalse): ${total} μs")

        start = System.nanoTime()
        ListOfBooleans5.matchAll(lastFalse)
        total = (System.nanoTime() - start) /10e3
        println(s"ListOfBooleans5.matchAll(lastFalse): ${total} μs")

        start = System.nanoTime()
        ListOfBooleans1.matchAll(firstTrue)
        total = (System.nanoTime() - start) /10e3
        println(s"ListOfBooleans1.matchAll(firstTrue): ${total} μs")

        start = System.nanoTime()
        ListOfBooleans5.matchAll(firstTrue)
        total = (System.nanoTime() - start) /10e3
        println(s"ListOfBooleans5.matchAll(firstTrue): ${total} μs")

        start = System.nanoTime()
        ListOfBooleans1.matchAll(lastTrue)
        total = (System.nanoTime() - start) /10e3
        println(s"ListOfBooleans1.matchAll(lastTrue): ${total} μs")

        start = System.nanoTime()
        ListOfBooleans5.matchAll(lastTrue)
        total = (System.nanoTime() - start) /10e3
        println(s"ListOfBooleans5.matchAll(lastTrue): ${total} μs")
    }

    "comp matchAny" should "be faster, but not" in {
        var start = 0L
        var total = 0d

        start = System.nanoTime()
        ListOfBooleans1.matchAny(fullTrue)
        total = (System.nanoTime() - start) /10e3
        println(s"ListOfBooleans1.matchAny(fullTrue): ${total} μs")

        start = System.nanoTime()
        ListOfBooleans5.matchAny(fullTrue)
        total = (System.nanoTime() - start) /10e3
        println(s"ListOfBooleans5.matchAny(fullTrue): ${total} μs")

        start = System.nanoTime()
        ListOfBooleans1.matchAny(fullFalse)
        total = (System.nanoTime() - start) /10e3
        println(s"ListOfBooleans1.matchAny(fullFalse): ${total} μs")

        start = System.nanoTime()
        ListOfBooleans5.matchAny(fullFalse)
        total = (System.nanoTime() - start) /10e3
        println(s"ListOfBooleans5.matchAny(fullFalse): ${total} μs")

        start = System.nanoTime()
        ListOfBooleans1.matchAny(firstFalse)
        total = (System.nanoTime() - start) /10e3
        println(s"ListOfBooleans1.matchAny(firstFalse): ${total} μs")

        start = System.nanoTime()
        ListOfBooleans5.matchAny(firstFalse)
        total = (System.nanoTime() - start) /10e3
        println(s"ListOfBooleans5.matchAny(firstFalse): ${total} μs")

        start = System.nanoTime()
        ListOfBooleans1.matchAny(lastFalse)
        total = (System.nanoTime() - start) /10e3
        println(s"ListOfBooleans1.matchAny(lastFalse): ${total} μs")

        start = System.nanoTime()
        ListOfBooleans5.matchAny(lastFalse)
        total = (System.nanoTime() - start) /10e3
        println(s"ListOfBooleans5.matchAny(lastFalse): ${total} μs")

        start = System.nanoTime()
        ListOfBooleans1.matchAny(firstTrue)
        total = (System.nanoTime() - start) /10e3
        println(s"ListOfBooleans1.matchAny(firstTrue): ${total} μs")

        start = System.nanoTime()
        ListOfBooleans5.matchAny(firstTrue)
        total = (System.nanoTime() - start) /10e3
        println(s"ListOfBooleans5.matchAny(firstTrue): ${total} μs")

        start = System.nanoTime()
        ListOfBooleans1.matchAny(lastTrue)
        total = (System.nanoTime() - start) /10e3
        println(s"ListOfBooleans1.matchAny(lastTrue): ${total} μs")

        start = System.nanoTime()
        ListOfBooleans5.matchAny(lastTrue)
        total = (System.nanoTime() - start) /10e3
        println(s"ListOfBooleans5.matchAny(lastTrue): ${total} μs")

    }
}
