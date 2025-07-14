package com.tufplus.binarySearch

object findIndex {

  //Input: nums = [1, 3, 5, 6, 10], target = 2
  def findIndexToInsert(arr: List[Int], target: Int): Int = {
    var startIndex = 0
    var endIndex = arr.length - 1
    while (startIndex <= endIndex) {
      val mid = (startIndex + endIndex) / 2
      if (arr(mid) == target) return mid
      else {
        if (arr(mid) > target) {
          endIndex = mid - 1
        } else startIndex = mid + 1
      }
    }
    startIndex
  }


  def functionalWay(arr: List[Int], target: Int) = {
    def recur(startIndex: Int, lastIndex: Int): Int = {
      val mid = (startIndex + lastIndex) / 2
      if (arr(mid) == target) mid
      else if (startIndex > lastIndex) startIndex
      else {
        recur(if (arr(mid) < target) mid + 1 else startIndex,
          if (arr(mid) < target) lastIndex else mid - 1)
      }
    }

    recur(startIndex = 0, lastIndex = arr.length - 1)
  }
}

//[1,2,5,6,8,9,22,55] 4
//7/2 ==> 3

// arr(3) 6 > 4 ans = 3
// mid = 1 2 > 4 ans = 1
//