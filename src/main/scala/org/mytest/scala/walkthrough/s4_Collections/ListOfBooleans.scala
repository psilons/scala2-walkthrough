package org.mytest.scala.walkthrough.s4_Collections

object ListOfBooleans
{
//    def main(args: Array[String]): Unit = {}
//
//    val booleans = List(true, false, true, false)
//    //val booleans = List(false, true, false, true)
//
//    // similar to python
//    println(booleans.forall(identity)) // return true only all true
//    println(booleans.exists(identity)) // return true if any is true
//
//    // use fold - IntelliJ prompts to use above
//    println(booleans.fold(true)((x, y) => x && y))
//    println(booleans.fold(false)((x, y) => x || y))
//
//    // the real logic
//    var res = true
//    booleans.foreach(b => res &&= b)
//    println(res)
//
//    res = false
//    booleans.foreach(b => res ||= b)
//    println(res)
//
//    // early stop - no diff between && and ||, only operators are different
//    // for and, if res = false at some point, break out
//    var earlyStop = false
//    res = true
//    booleans.view.takeWhile(_ => !earlyStop).foreach(b => {
//        res &&= b
//        // we want to derive same formula for and and or
//        // this is saying - stop at first false
//        // hardcoded true is really res's initial value, which flags for and or or operation
//        earlyStop = earlyStop || true != res
//    })
//    println(res)
//
//    // for or, if res = true at some point, break out
//    earlyStop = false
//    res = false
//    booleans.view.takeWhile(_ => !earlyStop).foreach(b => {
//        res ||= b
//        // correspondly, this says stop at first true
//        earlyStop = earlyStop || false != res
//    })
//    println(res)


}

object ListOfBooleans1 {
    def matchAll(booleans: Seq[Boolean]): Boolean = {
        booleans.forall(identity)
    }

    def matchAny(booleans: Seq[Boolean]): Boolean = {
        booleans.exists(identity)
    }
}

object ListOfBooleans2 {
    def matchAll(booleans: Seq[Boolean]): Boolean = {
        booleans.fold(true)((x, y) => x && y)
    }

    def matchAny(booleans: Seq[Boolean]): Boolean = {
        booleans.fold(false)((x, y) => x || y)
    }
}

object ListOfBooleans3 {
    def matchAll(booleans: Seq[Boolean]): Boolean = {
        var res = true
        booleans.foreach(b => res &&= b)
        res
    }

    def matchAny(booleans: Seq[Boolean]): Boolean = {
        var res = false
        booleans.foreach(b => res ||= b)
        res
    }
}

object ListOfBooleans4 {
    def matchAll(booleans: Seq[Boolean]): Boolean = {
        // early stop - no diff between && and ||, only operators are different
        // for and, if res = false at some point, break out
        var earlyStop = false
        var res = true
        booleans.view.takeWhile(_ => !earlyStop).foreach(b => {
            res &&= b
            // we want to derive same formula for and and or
            // this is saying - stop at first false
            // hardcoded true is really res's initial value, which flags for and or or operation
            earlyStop = earlyStop == res
        })
        res
    }

    def matchAny(booleans: Seq[Boolean]): Boolean = {
        // for or, if res = true at some point, break out
        var earlyStop = false
        var res = false
        booleans.view.takeWhile(_ => !earlyStop).foreach(b => {
            res ||= b
            // correspondly, this says stop at first true
            earlyStop = earlyStop != res
        })
        res
    }
}

object ListOfBooleans5 {
    def matchAll(booleans: Seq[Boolean]): Boolean = {
        comb(booleans, op = true)
    }

    def matchAny(booleans: Seq[Boolean]): Boolean = {
        comb(booleans, op = false)
    }

    // op = true for and, false for or
    def comb(booleans: Seq[Boolean], op: Boolean): Boolean = {
        var earlyStop = false
        var res = op
        booleans.view.takeWhile(_ => !earlyStop).foreach(b => {
            res = if (op) res && b else res || b
            // we want to derive same formula for and and or from case 4
            // for and, stop at first false
            // for or,  stop at first true
            // hardcoded true is really res's initial value, which flags for and or or operation
            // This works, but hard to understand
            //earlyStop = earlyStop || op != res

            // this is easier to understand
            // for and, find first false; for or find first true
            earlyStop = if (op) earlyStop == res else earlyStop != res
        })
        res
    }
}


