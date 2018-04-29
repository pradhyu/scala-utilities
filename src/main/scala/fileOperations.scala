object fileOperations {
  import sys.process._
  val files="ls"!!
  val fileName="README.md"
  import scala.io._
  import java.io.File
  Source.fromFile(new File(fileName)).getLines.mkString("/r/n")

}
