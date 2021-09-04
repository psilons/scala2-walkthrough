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

    // 2. Lists - operate at ends, flexible size
    // https://www.waitingforcode.com/scala-collections/collections-complexity-scala-immutable-collections/read
    // https://alvinalexander.com/scala/understanding-performance-scala-collections-classes-methods-cookbook/
    // https://alvinalexander.com/scala/how-to-create-mutable-list-in-scala-listbuffer-cookbook/
    val nums1: List[Int] = List(1, 2, 3)
    val nums2: Seq[Int] = 1 :: (2 :: (3 :: Nil)) // preappend is O(1)
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
