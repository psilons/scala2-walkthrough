package org.mytest.scala.walkthrough

import scala.collection.mutable

object S4_Collections
{
    def main(args: Array[String]): Unit = {} // every app needs a main()

    // the basic data structures needed
    // big picture of Scala collections
    // https://docs.scala-lang.org/overviews/collections/overview.html
    // https://docs.scala-lang.org/overviews/core/architecture-of-scala-collections.html
    // https://docs.scala-lang.org/overviews/collections/concrete-mutable-collection-classes.html

    // We look at arrays, lists, sets, and dictionaries
    // Mutable and Immutable
    // Parameterized types

    // 1. Arrays | ArrayBuffer - index based, size fixed
    var fruits: Array[String] = Array("apple", "orange", "banana")
    println(fruits.min)
    println(fruits.maxBy(_.length))
    import scala.util.Sorting.quickSort
    quickSort(fruits) // inplace sort
    println(fruits.mkString(", "))

    val fruits1: Seq[String] = Array("apple", "orange", "banana").toList.sorted
    println(fruits1)
    // More sorting: https://blog.knoldus.com/sorting-in-scala-using-sortedsortby-and-sortwith-function/
    // https://alvinalexander.com/scala/how-sort-scala-sequences-seq-list-array-buffer-vector-ordering-ordered/

    // multi-dimensions
    import Array._
    var matrix: Array[Array[Int]] = ofDim[Int](3, 3)
    for (i <- 0 until 3; j <- 0 until 3)
        matrix(i)(j) = i * j
    for (i <- 0 until 3; j <- 0 until 3)
        println(s"matrix[$i, $j] = ${matrix(i)(j)}")

    // tuples

    // 2. Lists - operate at ends, flexible size
    // https://www.waitingforcode.com/scala-collections/collections-complexity-scala-immutable-collections/read
    // https://alvinalexander.com/scala/understanding-performance-scala-collections-classes-methods-cookbook/
    // https://alvinalexander.com/scala/how-to-create-mutable-list-in-scala-listbuffer-cookbook/
    val nums1: List[Int] = List(1, 2, 3)
    val nums2: Seq[Int] = 1 :: (2 :: (3 :: Nil)) // preappend is O(1)
    val nums3: List[Int] = (1 to 10).toList // 1, 2, 3, 4, ... , 10
    val sliced = nums3.drop(2).grouped(3).map(_.head).toList // 3, 6, 9. tail is slow, so use head
    // ArrayBuffer is a mutable list
    // ListBuffer operates both ends with O(1)
    // https://www.scala-lang.org/api/current/scala/collection/mutable/ListBuffer.html

    // scala.collection.mutable.PriorityQueue is a heap implementation, just like Java.
    // TreeSet and TreeMap for ordered.

    // 3. sets
    var intSet = Set(1, 2, 3) // immutable
    println(intSet.contains(4)) // O(1)

    val old: Set[Int] = intSet
    intSet += 4 // new set
    println(intSet)
    println(intSet eq old) // false

    var stringSet: mutable.Set[String] = collection.mutable.Set("Chicago", "New York") // mutable
    stringSet.add("Boston")
    println(stringSet)

    // 4. maps
    import scala.collection._
    val myMap: Map[Int, Int] = Map((10 -> 5000), (20 -> 5000), (25 -> 7000), (40 -> 13000))
    val res = myMap.filter(k => k._1 > 30).map { case (key, value) => key * 10 -> value }
    println(res)
    val res1 = res.map { case (key, value) => key * 100}
    println(res1)
    // similar to set


    // 5. stacks
    val stack: mutable.Stack[String] = mutable.Stack("Chicago", "New York")
    stack.pop() // pop front
    println(stack)
    stack.push("Boston") // insert front
    println(stack)

    // 6. queues
    val queue: mutable.Queue[String] = mutable.Queue("Chicago", "New York")
    queue.dequeue() // pop front
    println(queue)
    queue.enqueue("Boston") // insert end
    println(queue)
}

// Sorting
// Ordering vs Ordered
// http://like-a-boss.net/2012/07/30/ordering-and-ordered-in-scala.html
