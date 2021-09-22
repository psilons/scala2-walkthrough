package org.mytest.scala.walkthrough.utils

import org.mytest.scala.walkthrough.utils.ContextManager._

import org.scalatest.flatspec.AnyFlatSpec

// https://alvinalexander.com/scala/how-to-open-read-text-files-in-scala-cookbook-examples/
// check file open: sudo lsof -u Al | grep '/etc/passwd'
class ContextManagerTest extends AnyFlatSpec
{
    it should "work" in {
        var cont: String = null

        withCtx(new Timer(), new File("build.sbt")) {
            // this is not working since we don't know the type.
            //cont = ctxs[1].getLines
        }
    }
}
