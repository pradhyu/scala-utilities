//Notebook:2D7RNB44W,0
//http://localhost:8080/#/notebook/2D7RNB44W


import sys.process._


val output="ls /"
println(output !!)
// !! to run the process

// This "fire-and-forgets" the method, which can be lazily read through
// a Stream[String]
def sourceFilesAt(baseDir: String): Stream[String] = {
  val cmd = Seq("find", baseDir, "-name", "*.sc", "-type", "f")
  cmd.lineStream
}

sourceFilesAt("/Users/pkshrestha/workspace/scala-utilities/").foreach(println)


// process Redirecting url to a file
import java.io.File
import java.net.URL
import scala.sys.process._

new URL("http://www.scala-lang.org/") #> new File("scala-lang.html") !

import scala.io._

Source.fromFile("scala-lang.html").getLines().mkString("\n")

// using process logger
//etcFiles.toString()

