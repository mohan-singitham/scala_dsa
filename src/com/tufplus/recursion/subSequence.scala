package com.tufplus.recursion

object subSequence {

  //Input : nums = [1, 2, 3, 4, 5] , k = 8
  //Output : Yes
  //Explanation : The subsequences like [1, 2, 5] , [1, 3, 4] , [3, 5] sum up to 8.

  def findSubSequenceExists(nums: Array[Int], sum: Int) = {
    def doRecur(index: Int, currentSum: Int): Boolean = {
      if (currentSum < 0) return false
      if (index == nums.length) return currentSum == sum
      if (currentSum == 0) return true

      doRecur(index + 1, currentSum - nums(index)) || doRecur(index + 1, currentSum)
    }

    doRecur(0, sum)
  }

  def findAllSubSequencePaths(nums: Array[Int], sum: Int) = {
    val listBuffer = scala.collection.mutable.ListBuffer[List[Int]]()

    def doRecur(index: Int, currentSum: Int, resArray: List[Int]): Int = {
      if (currentSum < 0) return 0
      if (index == nums.length) {
        if (currentSum == sum) {
          listBuffer += resArray
          return 1
        } else return 0
      }
      if (currentSum == 0) {
        listBuffer += resArray
        return 1
      }
      doRecur(index + 1, currentSum - nums(index), resArray :+ nums(index)) + doRecur(index + 1, currentSum, resArray)
    }

    listBuffer
  }


}
