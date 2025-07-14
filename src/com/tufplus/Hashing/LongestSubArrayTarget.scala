package com.tufplus.Hashing

object LongestSubArrayTarget {

  def getLongestSubArrayLength(arr: List[Int], target: Int): Int = {
    var prefixSum = 0
    var maxLength = 0
    var prefixHashMap = scala.collection.mutable.Map[Int, Int]()

    for (i <- arr.indices) {
      prefixSum += arr(i)

      if (prefixSum == target) {
        maxLength = i + 1
      }

      val diff = prefixSum - target

      if (prefixHashMap.contains(diff)) {
        val startIndex = prefixHashMap(diff)
        maxLength = Math.max(maxLength, i - startIndex)
      }

      if (!prefixHashMap.contains(diff)) {
        prefixHashMap(diff) = i
      }
    }
    maxLength
  }


  def getLongestSubArrayLength2(arr: List[Int], target: Int): Int = {
    var startIndex = 0
    var maxLength = 0
    var sum = 0
    for (lastIndex <- arr.indices) {
      sum += arr(lastIndex)

      while(sum > target && startIndex < lastIndex){
        sum -= arr(startIndex)
        startIndex = startIndex + 1
      }

      if(sum == target){
        maxLength = Math.max(maxLength, lastIndex - startIndex + 1)
      }
    }
    maxLength
  }

}
