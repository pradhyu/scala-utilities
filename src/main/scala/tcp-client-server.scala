// Simple client
import java.net._
import java.io._
import scala.io._
import scala.sys.process._



object server {
  // using akka for asynchronos processing 
  sealed trait ProcessMessage 
  case class UnitOfWork (command: String) extends ProcessMessage




  def startServer(port: String)= {
    import scala.sys.process._
    val pwd="pwd"!!
    val pwd1=pwd.stripLineEnd
    val cmd=s"${pwd1}/src/main/scala/goTcpServer"!!
  }
}

object client {
  val s = new Socket(InetAddress.getByName("localhost"), 9999)
  lazy val in = new BufferedSource(s.getInputStream()).getLines()
  val out = new PrintStream(s.getOutputStream())

  out.println("Hello, world")
  out.flush()
  println("Received: " + in.next())
  out.println("Hello, world Again")
  out.flush()
  println("Received:" + in.next())
  println("Received:" + in.next())

  s.close()
}
