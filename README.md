# scala2-walkthrough

Desired/First Impression: not KISS
- 80% of coding should be done in 20% APIs. With so many APIs, hard to know which one is faster.
- Fast coding like Python: short circuit frequently used APIs, like Python and C# syntax sugar.
  My LeetCode Python solutions are <= 20 lines mostly.
- With so many APIs, other tools such as IntelliJ is easy to be broken. Less used flexibility
  has virtually no value but confusion. We need an optimized version.

Wait until we get Spark.

[Scala docs](https://docs.scala-lang.org/api/all.html)

IntelliJ has Scala WorkSheet and Scala REPL

![repl](docs/scala_repl.png)

## Minimal Requirements

### sbt
[sbt Introduction](docs/sbt.md)

### Unit Tests and Test Coverage
[Unit Tests and Test Coverage](docs/test-coverage.md)

### Logging
https://github.com/lightbend/scala-logging is a wrapper around slf4j

http://software.clapper.org/grizzled-slf4j/index.html is another wrapper around slf4j.

## Profilers

IntelliJ has several profilers, https://blog.jetbrains.com/idea/2020/03/profiling-tools-and-intellij-idea-ultimate/

sbt has https://github.com/sbt/sbt-jmh.

https://github.com/jvm-profiling-tools/async-profiler/issues/381

Flamegraph:
- https://github.com/brendangregg/FlameGraph
- https://queue.acm.org/detail.cfm?id=2927301
- https://hacked.work/blog/flame-graphs-and-scala/
- https://johnysswlab.com/flamegraphs-understand-where-your-program-is-spending-time/


Performance testing tools:
- [scalameter](https://github.com/scalameter/scalameter). A good example is
  https://dev.to/awwsmm/benchmarking-scala-with-scalameter-pt-2-scala-dcp-004-4n93
- [gatling](https://github.com/gatling/gatling)

https://www.jetbrains.com/help/idea/java-flight-recorder.html#jfr-configurations

https://bell-sw.com/announcements/2020/07/22/Hunting-down-code-hotspots-with-JDK-Flight-Recorder/

https://www.brendangregg.com/flamegraphs.html

https://medium.com/@muuki88/follow-the-stacktraces-jvm-performance-profiling-3c371d323e5f

https://users.scala-lang.org/t/how-to-profile-my-code/4752/9

https://stackoverflow.com/questions/9160001/how-to-profile-methods-in-scala

https://dev.to/frosnerd/microbenchmarking-your-scala-code-4885

https://medium.com/virtuslab/revisiting-scala-native-performance-67029089f241
book: Modern Systems Programming with Scala Native

https://medium.com/swlh/performance-test-on-an-api-using-gatling-85319ee32faa
https://alexandreesl.com/2020/02/12/gatling-making-performance-tests-with-scala/

https://scalac.io/blog/performance-testing/

## UML and Class Diagrams
There is no good tool currently. We need a tool to show all relations
- classes
- hierarchy
- associations and dependencies

IntelliJ does a good job for Java, but not scala. Other tools, such as
[sbt-class-diagram](https://github.com/xuwei-k/sbt-class-diagram)
and 
[scaladiagrams](https://github.com/mikeyhu/scaladiagrams),
do not show all relations.

## Dependency Matrix
Dependency matrix - to analyze module dependencies

Started from [JDepend](https://github.com/nidi3/jdepend), now is 
[code-assert](https://github.com/nidi3/code-assert). IntelliJ has same
functionality here:

![dep_mtrx](docs/dependency_matrix.png)

Here is an internal 
[explanation](http://blog.rcard.in/programming/oop/software-engineering/2017/04/10/dependency-dot.html)
plus usage: 
https://dzone.com/articles/dependency-structure-matrix-for-software-architect

https://www.vojtechruzicka.com/idea-analyzing-dependencies/

https://www.jetbrains.com/help/idea/dependencies-analysis.html#analyze-dependencies

https://www.jetbrains.com/help/idea/dsm-analysis.html


## References

Images and links are from Amazon.

PiS4E: [Programming in Scala](https://www.amazon.com/Programming-Scala-Martin-Odersky/dp/098153161X) 

![pis4](docs/programming_in_scala_4E.jpg)

FPiS1E: [Functional Programming in Scala](https://www.amazon.com/Functional-Programming-Scala-Paul-Chiusano/dp/1617290653)

![fpis](docs/functional_programming_in_scala_1E.jpg)

SC1E: [Scala Cookbook](https://www.amazon.com/Scala-Cookbook-Object-Oriented-Functional-Programming/dp/1449339611)

![sc](docs/scala_cookbook_1E.jpg)

SFTI2E: [Scala for the Impatient](https://www.amazon.com/Scala-Impatient-2nd-Cay-Horstmann/dp/0134540565)

![sfti](docs/scala_for_the_impatient_2E.jpg)

https://baihuqian.github.io/tags/#Scala

https://www.baeldung.com/scala/category/scala-basics
