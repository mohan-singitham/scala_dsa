//Given an integer array nums, return true if any value appears more than once in the array, otherwise return false.
//
//Example 1:
//
//Input: nums = [1, 2, 3, 3]
//
//Output: true


object Solution {

  def hasDuplicate(input: Array[Int]): Boolean = {
    val mmap = scala.collection.mutable.Map[Int, Int]()
    input.exists(el => if(mmap.contains(el)) true else {mmap(el) = 1; false})
  }

}