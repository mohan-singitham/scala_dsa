package com.tufplus.Hashing

object LongestSequence {

  //Input: List(100, 4, 200, 1, 3, 2)
  //Output: 4           // Longest sequence: 1, 2, 3, 4
  //
  //Input: List(1, 2, 2, 3, 4)
  //Output: 4           // Longest sequence: 1, 2, 3, 4
  //
  //Input: List(10, 5, 6, 7, 20)
  //Output: 3           // Longest sequence: 5, 6, 7
  //
  //Input: List()
  //Output: 0           // Empty list → no sequence

  def longestConsecutive(arr: List[Int]) = {
    var maxConsecutive = if (arr.isEmpty) 0 else 1
    var maxTillNow = 1
    val setToCheck = arr.toSet
    var firstEle = setToCheck.headOption
    for (ele <- setToCheck.tail) {
      if (ele == firstEle.get + 1) {
        maxTillNow += 1
      } else {
        maxConsecutive = if (maxTillNow > 0) Math.max(maxTillNow, maxConsecutive) else 0
        maxTillNow = 1
      }
      firstEle = Some(ele)
    }
    maxConsecutive
  }


  def longestConsecutiveFunctional(arr: List[Int]) = {
    val setToCheck = arr.toSet
    var firstEle = setToCheck.headOption
    setToCheck.tail.foldLeft(((1, 1), firstEle)) { case (((maxConsecutive, maxTillNow), before), currentEle) =>
      if (before.contains(currentEle - 1)) {
        ((maxConsecutive.max(maxTillNow + 1), maxTillNow + 1), Some(currentEle))
      } else {
        ((maxConsecutive.max(maxTillNow), 1), Some(currentEle))
      }
    }._1._1
  }
}
