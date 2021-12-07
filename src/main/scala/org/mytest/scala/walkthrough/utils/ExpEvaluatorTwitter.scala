package org.mytest.scala.walkthrough.utils

import com.twitter.util.Eval

// not working, seems the lib is removed on scala 2.13
object ExpEvaluatorTwitter extends App
{
    def evaluate() = {
        val clazz = prepareClass
        val eval = new Eval
        eval.apply[Int](clazz)
      }

    private def prepareClass: String = {
        s"""
           |val x = 4
           |val y = 5
           |x + y
           |""".stripMargin
      }
}
