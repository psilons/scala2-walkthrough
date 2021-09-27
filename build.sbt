organization := "org.mytest.scala.walkthrough"

name := "scala2-walkthrough"

version := "1.0-SNAPSHOT"

scalaVersion := "2.13.6"

scalacOptions ++= Seq("-deprecation", "-feature")

libraryDependencies += "org.scalatest" %% "scalatest" % "3.2.9" % "test"
libraryDependencies += "com.typesafe.scala-logging" %% "scala-logging" % "3.9.4"
libraryDependencies += "ch.qos.logback" % "logback-classic" % "1.2.6"
libraryDependencies += "com.chuusai" %% "shapeless" % "2.3.7"
