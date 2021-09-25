package org.mytest.scala.walkthrough.utils

import com.typesafe.scalalogging.LazyLogging

class LoggingTest extends LazyLogging // or we could go with the normal way
{
    def testLogging() = {
        val abc = 5
        logger.info("This is a message {}", abc)
    }
}

object LoggingTest extends App {
    new LoggingTest().testLogging()
}
