package org.mytest.scala.walkthrough.s1_DataTypes

object StringTest extends App
{
    // Strings
    val ct: Char = 'a' // with or without type, no confusion
    val city: String = "New York" // with or without type, no confusion, re-point to java.lang.String
    println(city * 3)

    val escapes = "\n\r\t" // line returns and tab
    val multilines: String =
        """There are
          |3 lines
          |here""".stripMargin // this is to strip front space, marked by bars
    println(multilines)

    val abc = "Hello"
    val defg = 12.3
    println(s"This is $abc")
    println(f"This is $defg%.2f or $defg%.1f%%") // %% escape %
    println(f"This is $$$defg") // escape $
    println("This is %.2f or %s".format(defg, abc))
    println(raw"There is no \n\t substitution. $abc is fine")
}
