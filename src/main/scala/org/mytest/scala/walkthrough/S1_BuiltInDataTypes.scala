package org.mytest.scala.walkthrough

import scala.language.implicitConversions

object S1_BuiltInDataTypes // defined in scala package
{
    def main(args: Array[String]): Unit = {} // every app needs a main()

    val i = 1 // since no type declared, default to Int
    println(i)

    val d = 2.5 // since no type declared, default to Double
    println(d)

    // Built-in data types
    // Boolean
    val blt: Boolean = true // with or without type, no confusion

    // Strings
    val ct: Char = 'a' // with or without type, no confusion
    val city: String = "New York" // with or without type, no confusion, re-point to java.lang.String

    // Numbers
    val bt: Byte = 1 // 8-bit
    val st: Short = 1 // 16-bt
    val it: Int = 1 // 32-bit
    val lt: Long = 1 // 64-bit
    val ft: Float = 1 // 32-bit
    val dt: Double = 1 // 64-bit
    // Another way
    val annotatedLong: Long = 1:Long // valid but IntelliJ doesn't know it or not recommend it.

    val bit = BigInt(1234567890) // in scala.math, the argument can take various types
    val bit1 = BigInt("12345678901234567890")
    val bdt = BigDecimal(123.456)
    val bdt1 = BigDecimal("12345678901234567890.1")

    val longLiteral = 100L // L specifies Long
    val hexLiteral = 0xFF // integer 255 in hex
    val hexLongLiteral = 0xAAL // L for Long
    val floatLiteral = .35f
    val doubleLiteral = 1d // int to a double

    val escapes = "\n\r\t" // line returns and tab
    val multilines: String = """There are
          |3 lines
          |here""".stripMargin // this is to strip front space, marked by bars
    println(multilines)

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
    implicit def bool2int(b:Boolean): Int = if (b) 1 else 0
}

// See https://docs.scala-lang.org/tour/unified-types.html for type hierarchy

