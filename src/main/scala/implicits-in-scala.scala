package com.classPractise
// sealed class so that it couldn't be extended in any other file
sealed case class test (val test: String , val testSuite: String )
// covariants Practise, scala generics

class testCaseClass(val x: String, val y :String) extends test(x,y)
// A class could extend case class
// but invalid case class
//case class testCaseClass(val x: String, val y :String) extends test(x,y)
// above line would throw and error saying case inheritance is provhibited
// To make OOPS work with case classes.
// a better way is to do something like below

abstract class Fruit {
  def name: String
  def color: String
  def prettyPrint() {
    println(s"${this}")
  }
  override def toString: String = {
    s"Fruit:toString: ${name} & ${color}"
  }
}
/*
case classes must have parameters, without one
 use either case objects or case classes with an explicit `()' as a parameter list.
emplty () is also allowed for some reason
 */
case class Orange() extends Fruit {
  // scala puzzler: you do'nt need to override the name out here
  var name ="Orange"
  // overriding val is okay but for var
  // name_ is the getter and it overrides nothing
  override val  color ="Orange Color"
}

case class Apple() extends Fruit {
  override val name ="Apple"
  override val color ="Red Color"
}

// you can rather use class that extends a case class
class GreenApple(name: String, color: String) extends Apple {
  override def toString: String = {
    (s"GreenApple:toString: name-> ${name}, color-> ${color}}")
  }
  override def prettyPrint()  {
    println(s"GreenApple:Pretty Print: ${this}")
  }
  // custom pretty print especially defined for the GreenApple
  def customGreenApplePrettyPrint() {
    println(s"GreenApple:customGreenApplePrettyPrint:${this}")
  }
} 

object playground {
  val orange = new Orange()

  // you can't pass parameter to the case class that doesn't take one but  you can add a functional
  // representation {} to override the variable
  val orange2 = new Orange() {name="Override Orange"}
  // here you can reassign to a name but you can't do that to color since color is val and name is val

  val apple = new Apple()


  val greenApple = new GreenApple("GreenApple", "Green")

  greenApple.prettyPrint()
  greenApple.customGreenApplePrettyPrint()
  //apple doesn't have customGreenappleprettyprint so it should throw error
  // how ever we can make it work with implicits that converts the apple to GreenApple
  import scala.language.implicitConversions // if you con't import it it would throw some warning 
  implicit def appleToGreenApple (apple: Apple): GreenApple ={
    new GreenApple(apple.name, apple.color)}
  apple.customGreenApplePrettyPrint()
  // here you go the implicit would now give me apple -> green apple 
}


// this is how  you extend a class in scala
// remember you can't use the same variables in the extended class without overriding the variables
class extendedTest (val subTest: String, val subTestSuite: String, val extra: String) extends test (subTest , subTestSuite){
    println("extendedText Intiantiated")
}

// funny i can extend a class by passing it a value
class extendedTest2 extends test("what", "the Hell"){
  println("extendedTest2 Intiantiated")
}

// tester
object tester {
  val extendedTest=new extendedTest("testName", "testSuiteName", "extra")
  println (extendedTest)
}


// traits
// traits cannot have parameters
trait traitTest {
  val test: String ="traitTest"
  val testSuite: String
  var varTest: String
}

// you extend traits as well as classes
// no syntax differences, don't consider traits as the interface in java
// they are quiet different
abstract class traitTestImplementer extends traitTest
// not -> class traitTestImplementer extends traitTest with and unimplemented methods
// if you don't implement the values in trait then it needs to be defined abstract

// case classes without parameters are not allowed but
// its fine with classes

// multiple traits extended in a class
// if it has a same function how things work??
trait traitTest2 {
  val test: String ="traitTest2"
  def testSuite:String = { s"def traitTest2 testSuite" }
}

class traitTestExtender extends traitTest with traitTest2 {
  // if we don't override the test here it won't work
  override val test="Override testName"
  // must override testSuite def too 
  override val testSuite: String = "override testSuite"
  // to define varTest you must have var otherwise the getter function won't be overriden
   var varTest: String ="valVarTest"
}


object playgroundTrait {
  val tte=new traitTestExtender()
  println(tte.testSuite)
}

// another situation where we can pick the super method in the trait 
trait A { def hi = println("A") }
trait B { def hi = println("B") }

class C extends A with B {
  override def hi = super[B].hi
  def howdy = super[A].hi // if you still want A#hi available
}

// another alternative using base class and folling the hiearchy from right to left
trait Base {def hi: Unit}
trait X extends Base {override def hi = println("A")}
trait Y extends Base {override def hi = println("B")}
class Z extends X with Y
class W extends Y with X

object playgroundTrait2 {
  // you can't initialize a trait but adding {} creates a class out of it anyways
  (new B {}).hi // prints B 
  (new A {}).hi // prints A
  new A{}.hi // prints A
  (new C).hi // prints "B"
  (new C).howdy // prints "A" as we point the super to A.

// now using base trait we could achieve same thing
  new X{}.hi // returns A 
  new Y{}.hi // returns B
  new Z{}.hi // returns B as extends X With Y
    (new W).hi // returns A as extends Y with X
}

object playgroundTrait3 {

}


