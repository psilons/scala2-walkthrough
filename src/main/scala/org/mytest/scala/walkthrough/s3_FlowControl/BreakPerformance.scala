package org.mytest.scala.walkthrough.s3_FlowControl

import scala.collection.mutable.ArrayBuffer;
import scala.util.control.Breaks._;

// https://gist.github.com/freeeve/2430950
// while/continue 10000000 times in: 1090 ms; sanity check: 375098112
// breakable/foreach 10000000 times in: 1045 ms; sanity check: 375098112
// view/takeWhile/foreach 10000000 times in: 1644 ms; sanity check: 375098112
// while/seq(counter) 10000000 times in: 15328 ms; sanity check: 375098112
// for/guard 10000000 times in: 6798 ms; sanity check: 375098112

object BreakPerformance {
  def main(args:Array[String]):Unit = {
    val n = 100;
    val half = n/2;
    val halfPlus1 = half + 1;
    val iterations = 10000000;
    // intialize sequence
    val collection = {
      var temp = ArrayBuffer[Int]();
      for(i <- 1 to n) {
        temp += i;
      }
      temp.toSeq;
    }

    var count = 0;
    var start = System.currentTimeMillis();
    for(i <- 1 to iterations) {
      val it = collection.iterator;
      var continue = true;
      while(continue) {
        val v = it.next();
        count += v;
        if(v > half) continue = false;
      }
    }
    var end = System.currentTimeMillis();
    println("while/continue "+ iterations +" times in: " + (end-start) +" ms; sanity check: "+count);

    count = 0;
    start = System.currentTimeMillis();
    for(i <- 1 to iterations) {
      breakable {
        collection.foreach(v => {
          count += v;
          if(v > half) break();
        });
      }
    }
    end = System.currentTimeMillis();
    println("breakable/foreach "+ iterations +" times in: " + (end-start) +" ms; sanity check: "+count);

    count = 0;
    start = System.currentTimeMillis();
    for(i <- 1 to iterations) {
      collection.view.takeWhile(v => (v <= halfPlus1)).foreach(v => {
          count += v;
      });
    }
    end = System.currentTimeMillis();
    println("view/takeWhile/foreach "+ iterations +" times in: " + (end-start) +" ms; sanity check: "+count);

    count = 0;
    start = System.currentTimeMillis();
    for(i <- 1 to iterations) {
      var continue = true;
      var c = 0;
      while(continue) {
         val v = collection(c);
         c += 1;
         count += v;
         if(v > half) continue = false;
      }
    }
    end = System.currentTimeMillis();
    println("while/seq(counter) "+ iterations +" times in: " + (end-start) +" ms; sanity check: "+count);

    count = 0;
    start = System.currentTimeMillis();
    for(i <- 1 to iterations) {
      for(v <- collection if v <= halfPlus1) {
         count += v;
      }
    }
    end = System.currentTimeMillis();
    println("for/guard "+ iterations +" times in: " + (end-start) +" ms; sanity check: "+count);
  }
}
