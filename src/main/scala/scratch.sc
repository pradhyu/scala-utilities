

println("testing")


trait commandLineController {
  def run
  def process
}

class measuresEngineDirector extends commandLineController {

  override def run = print ("run")
  override def process = print("process")
}

val me = new measuresEngineDirector()

me.run
me.process
