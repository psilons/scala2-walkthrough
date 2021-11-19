package org.mytest.scala.walkthrough.s8_Implicits

// https://docs.scala-lang.org/overviews/core/implicit-classes.html
// https://www.baeldung.com/scala/implicit-classes
// http://allaboutscala.com/tutorials/chapter-3-beginner-tutorial-using-functions-scala/scala-tutorial-learn-create-implicit-function/
// https://docs.scala-lang.org/tour/implicit-parameters.html
// https://medium.com/@olxc/https-medium-com-olxc-implicits-in-scala-b2dcfccaa9e8

// Impatient Scala, chapter 21

// https://medium.com/@olxc/type-classes-explained-a9767f64ed2c#.1iodyt9w3
object ImplicitClasses extends App
{
    // suppose we have different types, just data
    case class Circle(radius: Double)
    case class Rectangle(width: Double, length: Double)

    // polymorphism -> function. Replace Shape with feature computing
    // now we want compute area (or parameter, or others) for the shape
    trait Shape[A] { // add features without changing Circle or Rectangle
      def area(a: A): Double
      def parameter(a: A): Double
    }

    implicit object CircleShape extends Shape[Circle] {
      override def area(circle: Circle) : Double = math.Pi * math.pow(circle.radius, 2)
      override def parameter(circle: Circle) : Double = math.Pi * circle.radius * 2
    }

    implicit object RectangleShape extends Shape[Rectangle] {
      override def area(rectangle: Rectangle): Double = rectangle.width * rectangle.length
      override def parameter(rectangle: Rectangle): Double = (rectangle.width + rectangle.length) * 2
    }

    def areaOf[A](shape: A)(implicit shapeImpl: Shape[A]): Double = shapeImpl.area(shape)
    def parameterOf[A](shape: A)(implicit shapeImpl: Shape[A]): Double = shapeImpl.parameter(shape)

    println( areaOf(Circle(10)) )
    println( areaOf(Rectangle(5,5)) )
    println( parameterOf(Circle(10)) )
    println( parameterOf(Rectangle(5,5)) )
}
