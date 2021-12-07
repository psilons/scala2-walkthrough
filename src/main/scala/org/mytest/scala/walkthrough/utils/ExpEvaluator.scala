package org.mytest.scala.walkthrough.utils

/**
 * Spring: https://docs.spring.io/spring-framework/docs/3.0.x/reference/expressions.html
 * Scala: https://stackoverflow.com/questions/39142979/dynamic-code-evaluation-in-scala#39143272
 * https://camunda.github.io/feel-scala/docs/1.12/reference/language-guide/feel-expression/
 * https://github.com/camunda/feel-scala
 */
object ExpEvaluator extends App
{
    // need to import scala-compiler
    import scala.tools.nsc.Settings
    import scala.tools.nsc.interpreter.IMain

//    def evaluate() = {
//        val clazz = prepareClass
//        val settings = new Settings
//        settings.usejavacp.value = true
//        settings.deprecation.value = true
//
//        val eval = new IMain(settings) // not working anymore
//        val evaluated = eval.interpret(clazz)
//        val res = eval.valueOfTerm("res0").get.asInstanceOf[Int]
//        println(res) //yields 9
//    }

  private def prepareClass: String = {
    s"""
       |val x = 4
       |val y = 5
       |x + y
       |""".stripMargin
  }
    import scala.reflect.runtime.universe
    import scala.tools.reflect.ToolBox

    val tb = universe.runtimeMirror(getClass.getClassLoader).mkToolBox()
    tb.eval(tb.parse("""println("hello!")"""))
    println(tb.eval(tb.parse(prepareClass)))

    // to add context parameters
    // https://stackoverflow.com/questions/59387459/how-to-get-the-runtime-value-of-parameter-passed-to-a-scala-macro

}
