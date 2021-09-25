# sbt Build Tool

sbt is the Scala build tool, similar to Maven for Java, makefile for C++.

## Installation
Download from: https://www.scala-sbt.org/index.html
Unzip the zip file and add the path to the PATH variable.

On Mac, we could run
```
brew install sbt
```

## Versions
to get **sbt** version, run ```sbt -v```

to get **Scala** version (Scala version is controlled by the build file)
```
sbt scalaVersion
```
or 
```
sbt "print scalaVersion"
```
The output is like:
```
[info] welcome to sbt 1.5.5 (Oracle Corporation Java 16.0.2)
[info] loading global plugins from C:\Users\Wonderland\.sbt\1.0\plugins
[info] loading project definition from D:\00dev\scala\scala2-walkthrough\project
[info] loading settings for project scala2-walkthrough from build.sbt ...
[info] set current project to scala2-walkthrough (in build file:/D:/00dev/scala/scala2-walkthrough/)
2.13.6
```
To remove the [info] lines
```
sbt --error 'print scalaVersion'
```
This sets the log level to error, so info prints are filtered out.

With multiple modules, the output is unpredictable. We could run
```
sbt --error 'print scalaVersion' | tail -1 | xargs
```
On windows, we need extra help to tail the last line and strip spaces in the front.

## sbt Console

To get Scala console
```
sbt console
```
(type in :q to quit). The standard console commands are listed in the IntelliJ sbt view
or https://www.scala-sbt.org/1.x/docs/Command-Line-Reference.html.

## sbt Tasks
The standard task list is also in the sbt view.

use compile and package for build and creating the jar.

Use JVM_OPTS or SBT_OPTS to set environment. For example
```
export SBT_OPTS="-XX:+CMSClassUnloadingEnabled -Xmx2G"
```


Standard Scala tasks are listed in the sbt view, such as clean, compile, package.
For uber jar, use assembly(https://github.com/sbt/sbt-assembly)

We may add dependency plugin in project/plugin.bat
```
addDependencyTreePlugin
```
Then we can see the full dependency tree
```
sbt dependencyTree
```
See more info in the [old doc](https://github.com/sbt/sbt-dependency-graph)

To use Ivy instead of Coursier,
```
sbt 'set ThisBuild / useCoursier := false' clean compile
```

To skip tests,
```
sbt 'set test in Test := {}' clean package
```
For other usage, see
```sbt help``` or see the [sbt doc](https://www.scala-sbt.org/1.x/docs/)
or [combined](https://www.scala-sbt.org/1.x/docs/Combined+Pages.html)

To build executables with all dependencies:
https://alvinalexander.com/scala/sbt-how-build-single-executable-jar-file-assembly/

The full version of scala used is
```
export full_version=$(sbt --error 'print scalaVersion' | tail -1 | xargs)
echo $full_version
2.13.6
```
The binary version(major + minor) is
```
export binary_version=${full_version%.*}
echo $binary_version
2.13
```

## Dependency Management

https://www.scala-sbt.org/1.x/docs/Library-Dependencies.html

https://www.scala-sbt.org/0.13/docs/Library-Management.html#Download+Sources

https://www.baeldung.com/scala/percent-symbols-build-sbt

https://www.scala-sbt.org/1.x/docs/Resolvers.html

Add this to the project/plugins.sbt
```
addDependencyTreePlugin
```
Then we could run this from command line:
```
sbt dependencyTree

[info] org.mytest.scala.walkthrough:scala2-walkthrough_2.13:1.0-SNAPSHOT [S]
[info]   +-com.typesafe.scala-logging:scala-logging_2.13:3.9.4 [S]
[info]     +-org.scala-lang:scala-reflect:2.13.6 [S]
[info]     +-org.slf4j:slf4j-api:1.7.30
```
More can be found in its github: https://github.com/sbt/sbt-dependency-graph.
