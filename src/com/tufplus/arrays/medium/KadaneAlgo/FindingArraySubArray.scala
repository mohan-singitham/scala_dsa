package com.tufplus.arrays.medium.KadaneAlgo

object FindingArraySubArray {

  def findingArraySubArray(arr: Array[Int]) = {
    var sum = 0
    var max = Int.MinValue

    for(i <- arr){
      sum = sum + i
     if(sum < 0) sum = 0
     else max = Math.max(max, sum)
    }
    max
  }

  //KADANES ALGORITHM----
  //start adding each element and if sum is negative, reassign sum to 0 and move forward

  def findingArraySubArrayFunctional(arr: Array[Int]) = {
    arr.foldLeft((0, Int.MinValue)){case ((sum, max), el) =>
      val newSum = Math.max(0, sum + el)
      val newMax = Math.max(max, newSum)
      (newSum, newMax)
    }._2
  }
}
