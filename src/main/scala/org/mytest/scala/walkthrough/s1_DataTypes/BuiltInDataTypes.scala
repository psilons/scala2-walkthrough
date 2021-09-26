package org.mytest.scala.walkthrough.s1_DataTypes

import scala.language.implicitConversions

// PiS4E Chapter 5
object BuiltInDataTypes // types defined in scala package
{
    def main(args: Array[String]): Unit =
    {} // every app needs a main(), or extends App

    // Boolean
    val blt: Boolean = true // with or without type, no confusion

    /*
    Type Casting

    Byte -> Short -> Int -> Long -> Float -> Double
                      ^
                      |
                     Char
    32-bit float range can cover 64-bit long
     */
    val x: Byte = 65
    val sx: Short = x
    val c: Char = 'A'
    val ix: Int = sx
    val ic: Int = c
    val lx: Long = ix
    val fx: Float = ix.toFloat
    val dx: Double = ix

    println(x.toShort) // another way to do it
    println(x.toInt)
    println(x.toLong)

    println(x.asInstanceOf[Double]) // 3rd way to do it
    println("2021".toIntOption) // it's an option now

    // To cast between int and boolean
    // https://stackoverflow.com/questions/2633719/is-there-an-easy-way-to-convert-a-boolean-to-an-integer
    implicit def bool2int(b: Boolean): Int = if(b) 1 else 0

    val a: Int = 1 + true
    println(a)

    println("123".toInt) // omit () on the method toInt()

    // enums in Scala 3
}
