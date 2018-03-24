// add deps
// libraryDependencies += "org.apache.spark" %% "spark-core" % "2.1.0"
// and run the worksheet in repl mode

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

val conf = new SparkConf()
conf.setMaster("local[*]")
conf.setAppName("Simple Application")

val sc = new SparkContext(conf)
val logFile = "/Users/pkshrestha/workspace/scala-utilities/src/main/resources/spark/ccioph-v240r0-f1.txt"
val logData = sc.textFile(logFile).cache()
val numAs = logData.filter(line => line.contains("a")).count()
val numBs = logData.filter(line => line.contains("b")).count()

println(s"Lines with a: $numAs, Lines with b: $numBs")

val numWithDate = logData.filter(line => line.contains("20180101")).count()

println(s"lines with date: $numWithDate")


// now playing with the data, load it to struct??
//RDD
val logDataRdd: RDD[String] =sc.textFile(logFile)

