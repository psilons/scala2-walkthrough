package org.mytest.scala.walkthrough.s5_Classes

class SimpleClass // This is constructor without parameter
{
    val x = 5 // immutable, public by default, instance variable
    private var y = 6 // mutable, private, instance variable

    def add(z: Int): Unit = { // public by default, return null
        y += z
    }

    def getY: Int = { // omit () when no parameter
        y
    }
}

object SimpleClass { // companior object, can access private members of each other
    def main(args: Array[String]): Unit = {
        val myObj = new SimpleClass() // primary default constructor
        myObj.add(4)
        println(myObj.x)
        println(myObj.getY)
    }
}
