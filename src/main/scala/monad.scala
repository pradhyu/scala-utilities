// Monads in scala

// Some thing i found in medium.com

// Monda functions

// flatMap

// Signature-> def flatMap[B](f: (A) => U[B]): U[B]
object demystifyingMondasInScala {
  val list = List(5, 6, 7)
  val f = (i: Int) => List(i - 1, i, i + 1)
  println(list.flatMap(f))
}
