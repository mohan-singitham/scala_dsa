package com.tufplus.arrays.easy.RemoveDuplicatesSorted

object RemoveDuplicatesFromSortedArray {

  //Example 1
  //Input: nums = [0, 0, 3, 3, 5, 6]
  //Output: [0, 3, 5, 6, _, _]
  //Explanation: There are 4 distinct elements in nums and the elements marked as _ can have any value.
  //Example 2
  //Input: nums = [-2, 2, 4, 4, 4, 4, 5, 5]
  //Output: [-2, 2, 4, 5, _, _, _, _]
  //Explanation: There are 4 distinct elements in nums and the elements marked as _ can have any value.

  def removeDuplicatesFromSortedArray(arr: Array[Int]) = {
    var i = 0

    for (j <- i + 1 until arr.length) {
      if (arr(i) != arr(j)) {
        arr(i + 1) = arr(j)
        i = i + 1
      }
    }
    arr
  }
}

