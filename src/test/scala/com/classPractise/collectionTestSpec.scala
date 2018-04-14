import org.scalatest._



class collectionTestSuite extends FunSuite {
  test("take two from list of (1 2 3 4) should be (1 2)") {
    val xs=List(1,2,3,4)
    assert(xs.take(2) == List(1,2))
  }

  test("tabulate: auto generate lists ") {

}


}
