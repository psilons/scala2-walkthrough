package org.mytest.scala.walkthrough.S5_Classes

// case classes need constructor parameters
case class CaseClass(var a: String)
{

}

// case-to-case inheritance is not allowed
//case class MyExtendedCaseClass(override var a: String) extends CaseClass(a)
