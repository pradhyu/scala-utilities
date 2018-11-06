import scala.sys.process._

object processBuilder {
  // single process -> output to stdout
  "ls".!
    // return string output in stdout
    ("ls".!!).stripLineEnd
  // create Stream[String]
  val contents = Process("ls").lineStream
  contents.foldLeft("")(_ + "\r\n"+ _)

  // to make it whitespace safe 
  def contentOf(dir: String): String = Seq("ls",dir).!!

  // TODO  content of
  contentOf("/Users/")

  // get exit code from process 
  val ps=Process("ls")
  val exitValue=ps.run().exitValue()

  // it also support processpiping like we pipe in bash
  // Bottom line use Akka for long running process and better process management

  // spawning process 

  val emacsPs = Process("emacs")
  val psOut=emacsPs.run()
  psOut.destroy
  // exit value is only returned when the application exits
  psOut.exitValue()


//some background process 
  val proc = Process(Seq("sleep", "50000"))
  val bgProc = proc.run
  bgProc.destroy
  // exit value is only returned when the application exits
  bgProc.exitValue

  // do we even need future ??
  val proc1 = Process(Seq("sleep", "50000"))
  val bgProc1 = proc.run
  bgProc1.destroy



  

}
