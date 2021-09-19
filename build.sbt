organization := "org.mytest.scala.walkthrough"

name := "scala2-walkthrough"

version := "1.0-SNAPSHOT"

scalaVersion := "2.13.6"

scalacOptions ++= Seq("-deprecation", "-feature")

libraryDependencies += "org.scalatest" %% "scalatest" % "3.2.9" % "test"
libraryDependencies += "com.typesafe.scala-logging" %% "scala-logging" % "3.9.4"
