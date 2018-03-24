
import akka.routing.RoundRobinPool

import sys.process._
// needs to have dependency in the build.sbt
import akka.actor._

// run shell application that runs for ever and listens to a socket
//"pkill goTcpServer" !!
val serverAppPath = "/Users/pkshrestha/workspace/scala-utilities/src/main/scala/goTcpServer"
//serverAppPath !!


// need to use aka actor to handle the concurrency.
// Few classes to pass
sealed trait ProcessMessage
case object Calculate extends ProcessMessage
case class Work(start: Int, nrOfElements: Int) extends ProcessMessage
case class Result(value: String) extends ProcessMessage

def doWork(start: Int, nrOfElements: Int): String = {
  println("doWork!!!")
  Thread.sleep(1000)
  s"Received parameters $start, $nrOfElements"
}

class Worker extends Actor {
  override def receive = {
    case Work(start, nrOfElements) => {
      println("\nWork received")
      sender ! Result(doWork(start, nrOfElements))
  }
  }
}

class Master(nrOfWorkers: Int, nrOfMessages: Int) extends Actor {

  val workerRouter = context.actorOf(
    Props[Worker].withRouter(RoundRobinPool(nrOfWorkers)), name = "workerRouter")

  val nrOfElements = 2;
  override def receive = {
    case Calculate =>
      println("\nCalculation started")
      for ( i <- 0 until nrOfMessages) workerRouter ! Work(i * nrOfElements, nrOfElements )

    case Result(value) =>
      println(s"\n\tMaster received result: $value")
      // Stops this actor and all its supervised children
      context.stop(self)
  }
}

// make sure application.conf is in src/main/resources directory
// make sure "Use REPL Mode is checked in the worksheet"
// create the mastero
val system = ActorSystem("PiSystem")
val (nrOfWorkers, nrOfMessages) = (2, 10)
val master = system.actorOf(Props(new Master(
  nrOfWorkers, nrOfMessages)),
  name = "master")

// start the calculation
master ! Calculate






