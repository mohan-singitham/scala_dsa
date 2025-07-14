package com.tufplus.arrays.easy.leftrotate

object LeftRotate {

  //Given an integer array nums, rotate the array to the left by one.
  //Example 1
  //Input: nums = [1, 2, 3, 4, 5]
  //Output: [2, 3, 4, 5, 1]
  //Explanation: Initially, nums = [1, 2, 3, 4, 5]
  //Rotating once to left -> nums = [2, 3, 4, 5, 1]
  //Example 2
  //Input: nums = [-1, 0, 3, 6]
  //Output: [0, 3, 6, -1]
  //Explanation: Initially, nums = [-1, 0, 3, 6]
  //Rotating once to left -> nums = [0, 3, 6, -1]

  def leftRotateByOnePosition(arr: Array[Int]) = {
    val tmp = arr(0)
    for(i<-1 until arr.length){
      arr(i-1) = arr(i)
    }
    arr(arr.length - 1) = tmp
    arr
  }

}
