package com.classPractise.tests
// remember the package name shouldn't have the objects defined inside the package
// for example if you name the package com.classPractise.test it will throw error 
// since test object is already a case class inside the com.classPractise package 
import org.scalatest._
import org.scalatest.FunSuite
import org.scalatest.FunSpec
import com.classPractise._



class classPractiseTestSuiteSpec extends FunSuite {
  test("creating a extendedTest: testName") {
    val extendedTest = new extendedTest("testName", "testSuiteName", "extra")
    assert (extendedTest.test == "testName" )
    val extendedTest2 = new extendedTest("testName", "testSuiteName", "extra")
    assert (extendedTest2.subTest=="testName")

  }
  test ("creating extendedTest2 without parameter and checking defaulte test name") {
    val extendedTest3 = new extendedTest2()
    assert (extendedTest3.test=="what")
}

  test ("creating extendedTest2 without parameter and checking testSuite name") {
    val extendedTest3 = new extendedTest2()
    assert (extendedTest3.testSuite=="what")
    assert (extendedTest3.testSuite=="the Hell")
  }
}





