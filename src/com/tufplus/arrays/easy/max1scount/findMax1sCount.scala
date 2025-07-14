package com.tufplus.arrays.easy.max1scount

object findMax1sCount {

  //Given a binary array nums, return the maximum number of consecutive 1s in the array.
  //
  //A binary array is an array that contains only 0s and 1s.
  //Example 1
  //Input: nums = [1, 1, 0, 0, 1, 1, 1, 0]
  //Output: 3
  //Explanation: The maximum consecutive 1s are present from index 4 to index 6, amounting to 3 1s
  //Example 2
  //Input: nums = [0, 0, 0, 0, 0, 0, 0, 0]
  //Output: 0
  //Explanation: No 1s are present in nums, thus we return 0

  def findMax1sCount(arr: List[Int]) = {
    var countOf1s, result = 0
    for (i <- arr.indices) {
      if (arr(i) == 1) {
        countOf1s = countOf1s + 1
        result = Math.max(result, countOf1s)
      } else {
        countOf1s = 0
      }
    }
    result
  }

  def findMax1sCountFunctional(arr: List[Int]) = {
    arr.foldLeft((0, 0)) { case ((result, max1s), ele) =>
      if (ele == 1) {
        (result max (max1s + 1), max1s + 1)
      } else (result, 0)
    }._1
  }


}
