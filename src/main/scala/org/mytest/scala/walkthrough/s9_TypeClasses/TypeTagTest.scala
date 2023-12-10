package org.mytest.scala.walkthrough.s9_TypeClasses

// https://stackoverflow.com/questions/11127164/how-to-determine-whether-a-type-parameter-is-a-subtype-of-a-trait

class Foo
trait Bar

import reflect.runtime.universe.{TypeTag, typeOf, typeTag}

object TypeTagTest extends App
{
    def isBar[A <: Foo : TypeTag] = typeOf[A].baseClasses.contains(typeOf[Bar].typeSymbol)

    println(isBar[Foo])
    println(isBar[Foo with Bar])

    val fooBar = typeTag[Foo with Bar]
    println(fooBar.tpe) // tpe has all reflections
}
