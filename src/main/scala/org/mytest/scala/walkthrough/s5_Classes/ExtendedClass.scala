package org.mytest.scala.walkthrough.s5_Classes

class ParentClass(var a: String, var b: Int) {
    def calc: Int = {
        a.toInt + b
    }
}

class ExtendedClass(a: String, b: Int) extends ParentClass(a, b)
{

}


// https://stackoverflow.com/questions/22288496/return-this-in-a-covariant-trait-that-return-actual-type
// to handle this as return
