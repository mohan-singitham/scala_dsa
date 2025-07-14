package com.tufplus.arrays.medium.TwoSum

object TwoSum {

  //using hashmap
  def twoSum(arr: List[Int], target: Int): (Int, Int) = {
    val mmap = scala.collection.mutable.Map[Int, Int]()
    arr.zipWithIndex.map{case (el, index) =>
      if(mmap.contains(target - el)){
        return (mmap(target - el), index)
      }else mmap+= (el -> index)
    }
    (-1,-1)
  }

  //Using 2 pointer approach
  def twoSum2(arr: List[Int], target: Int): (Int, Int) = {
    var left = 0
    var right = arr.size - 1

    //returning index of sorted list which is wrong here
    val sortedList = arr.sorted
    while(left < right){
      if(sortedList(left) + sortedList(right) == target){
        return (left, right)
      }else if(sortedList(left) + sortedList(right) > target){
      right = right -1
      }else left = left + 1
    }
    (-1,-1)
  }


}
