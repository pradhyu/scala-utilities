/*
 Scala Extractors 
 use pattern matching  to decompose the data structures
 Based on "The Neophyte's Guide to Scala"
 */

// extractor comes by default in case class 
// the unapply method
object Extractor {
  // case class cannot extend case class 
  // let's use a trait 

  sealed trait User {// seal it we don't want to have it extended in any other file 
    def status: UserStatus.Value=UserStatus.Inactive// use enum
  }

  object UserStatus extends Enumeration {
    val Active, Inactive, Pending = Value
  }
  case class Location (val name: String, loc: Int= 0, Lat: Int = 0)

  case class Parent (firstName: String, lastName: String, location: Location) extends User

  case class Kid(parent: Parent) extends User

  def extractLocation(usr: User) = {
    usr match {
      case Parent(_,_, location) => location
      case Kid(parent) => parent.location
      case _ => 0
    }
  }

  // mapper user -> age
  val loc=Location("1831 Talking Rock Drive", 99,99)
  val pk =Parent("PK","Shresetha", loc)
  val pari=Parent("Parijat", "Malla", loc)
  List(pk,pari, Kid(pari)).map(extractLocation(_))


}



