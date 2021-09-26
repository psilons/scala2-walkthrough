package org.mytest.scala.walkthrough.s1_DataTypes

object NumberTest extends App
{
    val i = 1 // since no type declared, default to Int
    println(i)

    val d = 2.5 // since no type declared, default to Double
    println(d)

    // Numbers
    val bt: Byte = 1 // 8-bit
    val st: Short = 1 // 16-bt
    val it: Int = 1 // 32-bit
    val lt: Long = 1 // 64-bit
    val ft: Float = 1 // 32-bit
    val dt: Double = 1 // 64-bit
    // Another way
    val annotatedLong: Long = 1: Long // valid but IntelliJ doesn't know it or not recommend it.

    val bit = BigInt(1234567890) // in scala.math, the argument can take various types
    val bit1 = BigInt("12345678901234567890")
    val bdt = BigDecimal(123.456)
    val bdt1 = BigDecimal("12345678901234567890.1")

    val longLiteral = 100L // L specifies Long
    val hexLiteral = 0xFF // integer 255 in hex
    val hexLongLiteral = 0xAAL // L for Long
    val floatLiteral = .35f
    val doubleLiteral = 1d // int to a double

    // PS3E, provide just enough hints
    val x = 123_456
    val y = 0x123_a4b
    val z, u = 123L // multiple assignment
    println(z)
    println(u)
}
