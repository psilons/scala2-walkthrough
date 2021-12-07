organization := "org.mytest.scala.walkthrough"

name := "scala2-walkthrough"

version := "1.0-SNAPSHOT"

scalaVersion := "2.13.6"

scalacOptions ++= Seq("-deprecation", "-feature")

libraryDependencies += "org.scalatest" %% "scalatest" % "3.2.9" % "test"
libraryDependencies += "com.typesafe.scala-logging" %% "scala-logging" % "3.9.4"
libraryDependencies += "ch.qos.logback" % "logback-classic" % "1.2.6"
libraryDependencies += "com.chuusai" %% "shapeless" % "2.3.7"

// for evaluation: https://gist.github.com/ykskm/2275338
libraryDependencies += "org.scala-lang" % "scala-compiler" % scalaVersion.value

resolvers += "Twitter repo" at "https://maven.twttr.com/"
libraryDependencies ++= Seq(
    "com.twitter" % "util-eval" % "6.43.0"
)
// twitter needs this
libraryDependencies += "org.scala-lang" % "scala-library" % scalaVersion.value
