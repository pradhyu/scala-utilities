object eightQueenProblem {
  println("testing")
  // eight queen problem is for backtracking 
  // create a simple matrix
//  val matrix = Array.ofDim[Int](3,3)

  val matrix = for( c <- (1 to 3); r<- (1 to 3)) yield (c,r)

  def printMatrix(matrix: Any): Unit = {
    println(matrix)}



}
