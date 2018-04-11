name := "scala-utilities"

version := "0.1"

scalaVersion := "2.11.5"

libraryDependencies += "net.ruippeixotog" %% "scala-scraper" % "2.0.0"

// for akka dependencies


libraryDependencies ++= Seq(
  "com.typesafe.akka" %% "akka-actor"    % "2.4.16",
  "com.typesafe.akka" %% "akka-slf4j"    % "2.4.16",
  "com.typesafe.akka" %% "akka-remote"   % "2.4.16",
  "com.typesafe.akka" %% "akka-agent"    % "2.4.16",
  "com.typesafe.akka" %% "akka-testkit" %  "2.4.16" % "test"
)

// for spark scala worksheet integration
// spark needs scala 2.11.X
libraryDependencies += "org.apache.spark" %% "spark-core" % "2.2.1"

// for scala test
// specify this dependency is for test to make ensime not show 
// scala test as errors in the editor o
libraryDependencies += "org.scalatest" % "scalatest_2.11" % "3.0.5" % "test"

// Mysql driver 
val mysql = "mysql" % "mysql-connector-java" % "5.1.12"
libraryDependencies += mysql



