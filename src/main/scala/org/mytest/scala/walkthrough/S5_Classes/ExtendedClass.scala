package org.mytest.scala.walkthrough.S5_Classes

class ParentClass(var a: String, var b: Int) {
    def calc: Int = {
        a.toInt + b
    }
}

class ExtendedClass(a: String, b: Int) extends ParentClass(a, b)
{

}
