package com.scala.algorithm
// Recursion and Backtracking 

object backtracking {

// factorial without accumulator or tail recurson
  def factorial(num: Int): Int = {
    if (num==0) return 1
    return num * factorial(num -1)
  }
  val fac10=factorial(10)
  val factZero=factorial(0)

  def factorialWithTailRecur(num: Int) : Int = {
    def facAccu(accu: Int, num: Int): Int = {
      if(num==0) return accu
      return facAccu(accu*num, num-1)
    }

   facAccu(1,num)
  }
  factorialWithTailRecur(10)
}
