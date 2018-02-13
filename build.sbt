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


