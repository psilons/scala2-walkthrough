package org.mytest.scala.walkthrough

package object S6_Functions // package object of the package
{
    // This is where we define functions
    def fullName(lastname: String, firstname: String): String = {
        lastname + ", " + firstname
    }
}
