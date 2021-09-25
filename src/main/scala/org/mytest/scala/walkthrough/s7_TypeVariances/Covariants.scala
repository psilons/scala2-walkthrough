package org.mytest.scala.walkthrough.s7_TypeVariances

// https://docs.scala-lang.org/tour/variances.html
class Foo[+A] // A covariant class
class Bar[-A] // A contravariant class
class Baz[A]  // An invariant class

// https://stackoverflow.com/questions/663254/why-doesnt-the-example-compile-aka-how-does-co-contra-and-in-variance-w
// This is not working
//class Slot[+T] (var some: T) {
//}

// This is working
class Slot[+T, V <: T] (var some: V) {
    def getT: V = { some }
}

// Another example from Scala API - +R is on the return type
trait Function1[-P, +R] {
  def apply(p: P): R
}
//T1' <: T1
//T2 <: T2'
//---------------------------------------- S-Fun
//Function1[T1, T2] <: Function1[T1', T2']

// Another example
// not working
//trait List[+A] {
//  def cons(hd: A): List[A] // complains here
//}
// working
trait List[+A] {
  def cons[B >: A](v: B): List[B] // +A on the return type, so use B
}

// change var to val, it's fine
class Slot1[+T] (val some: T) {
}
// but with var, this is why it's not allowed
//  class Slot[+T](var some: T) {
//    def get: T = some
//  }
//
//  val slot: Slot[Dog] = new Slot[Dog](new Dog)
//  val slot2: Slot[Animal] = slot  //because of co-variance
//  slot2.some = new Animal   //legal as some is a var
//  slot.get ??

// see reference html files (respect to their authors)
// https://typelevel.org/blog/2016/02/04/variance-and-functors.html
// https://www.youtube.com/watch?v=aUmj7jnXet4
// https://blog.rockthejvm.com/
// https://stackoverflow.com/questions/27414991/contravariance-vs-covariance-in-scala
// https://docs.scala-lang.org/tour/variances.html
class Covariants
{

}

