package org.mytest.scala.walkthrough.s9_TypeClasses

// https://www.baeldung.com/scala/type-classes
// https://docs.scala-lang.org/scala3/book/types-type-classes.html
object TypeClass extends App
{
    // This is very useful for readable code, otherwise we have to use variable name
    // to make it readable, such as userId2user
    // https://www.vlachjosef.com/tagged-types-introduction/
    // https://github.com/milessabin/shapeless
    trait FirstNameTag
    trait LastNameTag
    trait AgeTag

    import shapeless.tag.@@
    import shapeless.tag

    type FirstName = String @@ FirstNameTag
    type LastName = String @@ LastNameTag
    type Age = Int @@ AgeTag

    case class Person(fn: FirstName, ln: LastName, age: Age)


    // this is not working since types are not matched
    //println(Person("Joe", "Smith", 15))
    val fn: FirstName = tag[FirstNameTag][String]("Joe")
    val ln: LastName = tag[LastNameTag][String]("Smith")
    val age: Age = tag[AgeTag][Int](20)
    println(Person(fn, ln, age))
    // This is tedious, so Scala3 introduce opaque types, PS3E page 289

    // this is not working, good guard on types, though they are all strings.
    // println(Person(ln, fn, age))
}

// PS3E Page 101, abstract type member







