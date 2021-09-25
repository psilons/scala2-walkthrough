package org.mytest.scala.walkthrough.s5_Classes

class PrimaryConstructor(var a: String, var b: Int) {
    def calc(c: Float): Float = {
        a.toFloat + b + c
    }
}

// https://www.baeldung.com/scala/classes-objects
class AuxiliaryConstructor(var a: String, var b: Int) { // primary constructor
    def this(a: String) = { // auxiliary constructor
        this(a, 10)
    }

    def this(b: Int) = { // auxiliary constructor
        this("1000", b)
    }

    def this() = {
        this("1000", 10)
    }

    // another way to do this is via default parameter values
    // https://docs.scala-lang.org/tour/default-parameter-values.html
}
