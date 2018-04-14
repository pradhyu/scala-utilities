// collections object 

/*
 How to use the scala tabulate method -
 Use on List, Array, Vector, Seq, and mor
 Scala collections follow a simple set of general equality rules[1]. Two collections are equal if:

 they are in the same overall category (Seq, Set, or Map)
 they contain the same elements (as defined by ==)
 for sequences, the elements are in the same order
 */
object collectionTabulate {
  val xs=List.tabulate(5)(_ + 1)
  val xs2=List.tabulate(5)(_ + 2)
  val xs3=List.tabulate(5)(_ *2)
  // starts from 20 
  val xa=Array.tabulate(5)(_ + 10)
  val xv=Vector.tabulate(6) (_ + 100)
  val xseq=Seq.tabulate(5) (_ % 2)



}

object collectionListArrayBuffer {
  // list comparision with vector
  assert(List(1,2,3) == Vector(1,2,3))
  assert(List(1,2,3)==Seq(1,2,3))

  // set and sequences don't match 
  assert(List(1,2,3)==Set(1,2,3))

  // both in set category 
  assert(Set(1,2,3)== collection.immutable.HashSet(1,3,2))
  assert(Set(1,2,3)== collection.mutable.LinkedHashSet(1,3,2))



  /*
   Arrays Don't behave the way list, seq and set behaves 
   */

  import scala.collection.mutable.ArrayBuffer

  val fruits = ArrayBuffer("apple", "orange", "cherry")
  // simple make string
  assert(fruits.mkString(",") == "apple,orange,cherry")
  // convert it back to array
  fruits.toArray

  // array equality check
  //deep comparisions
  assert (fruits.toArray.deep ==Array("apple","orange","cherry").deep)
  // or you can  use sameElements
  assert (fruits.toArray.sameElements(Array("apple","orange","cherry")))

  // works differently in scala and java
  java.util.Arrays.equals(Array(1,2), Array(1,2)) // => true
  Array(1,2).equals(Array(1,2))// => false




  // add two interables in form of an array buffers
  val fruits2=fruits ++ ArrayBuffer("bad apple", "bad Orange")
  // clear fruits2
  assert(fruits2.length==5)


}


