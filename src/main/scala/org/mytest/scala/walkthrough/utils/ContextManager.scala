package org.mytest.scala.walkthrough.utils

// This idea is not working for multi context manager.
// For single context manager, see loan pattern in here
// https://alvinalexander.com/scala/how-to-open-read-text-files-in-scala-cookbook-examples/

// For multiple context manager, see: https://github.com/jsuereth/scala-arm
// https://stackoverflow.com/questions/8865754/scala-finally-block-closing-flushing-resource
// https://stackoverflow.com/questions/4604237/how-to-write-to-a-file-in-scala/34277491#34277491
// In scala 2.13, use the Using: https://stackoverflow.com/questions/57353702/cleaner-approach-for-quetly-closing-multiple-resources-in-scala


// implement Python's context manager for auto close
// https://www.pythontutorial.net/advanced-python/python-context-managers/
object ContextManager
{
    def withCtx[T <: ContextManager, R](ctxs: T*)(func: => R): Seq[T] = {
        ctxs.foreach(_.enter())
        try
            func
        finally
            ctxs.foreach(_.exit())
        ctxs
    }
}

trait ContextManager
{
    def enter(): Unit = () // or ???, pass in python

    def exit(): Unit = () //
}

class Timer(durUnit: String = "ns") extends ContextManager
{
    var start: Long = 0L
    var end: Long = 0L
    var dur: Double = 0L

    override def enter(): Unit = {
        start = System.nanoTime()
    }

    override def exit(): Unit = {
        dur = System.nanoTime() - start
        dur = durUnit match {
            case "hour" => dur / 10e9 / 3600
            case "min" => dur / 10e9 / 60
            case "sec" => dur / 10e9
            case "ms" => dur / 10e6
            case "us" => dur / 10e3
            case _ => dur
        }
    }
}

import scala.io.{BufferedSource, Source}

class File(fileName: String) extends ContextManager
{
    private val _fileName = fileName
    var _source: Option[BufferedSource] = None

    override def enter(): Unit = {
        _source = Some(Source.fromFile(_fileName))
    }
    override def exit(): Unit = {
        if (_source.isDefined)
            _source.get.close
    }
}
