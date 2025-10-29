//Given an array of integers nums, return the length of the longest consecutive sequence of elements that can be formed.
//
//A consecutive sequence is a sequence of elements in which each element is exactly 1 greater than the previous element. The elements do not have to be consecutive in the original array.
//
//You must write an algorithm that runs in O(n) time.
//
//Example 1:
//
//Input: nums = [2,20,4,10,3,4,5]
//
//Output: 4


object LongestConsecutive {

  def longestConsecutive(arr: Array[Int]) = {
    var count = 0
    val freqMap = scala.collection.mutable.Map[(Int, Int)]()

    arr.foreach(el =>
      freqMap += (el -> freqMap.getOrElse(el, 0) + 1)
    )

    arr.foreach(el =>
      if (!freqMap.contains(el - 1)) {
        var tmp = el
        var result = 0
        while (freqMap.contains(tmp)) {
          result += 1
          tmp += 1
        }
        count = Math.max(count, result)
      }
    )
    count
  }
}