package com.tufplus.arrays.easy.missingNumber

object MissingNumber {
  //Given an integer array of size n containing distinct values in the range from 0 to n (inclusive), return the only number missing from the array within this range.
  //Input: nums = [0, 2, 3, 1, 4]
  //Output: 5
  //Explanation: nums contains 0, 1, 2, 3, 4 thus leaving 5 as the only missing number in the range [0, 5]
  //Example 2
  //Input: nums = [0, 1, 2, 4, 5, 6]
  //Output: 3
  //Explanation: nums contains 0, 1, 2, 4, 5, 6 thus leaving 3 as the only missing number in the range [0, 6]

  def findMissingNumberInRange(arr: Array[Int], n: Int) = {
    val lengthOfArray = n - 1

    val xor1 = arr.foldLeft(0)(_ ^ _)
    val xor2 = (0 until lengthOfArray).foldLeft(0)(_ ^ _)

    xor1 ^ xor2
  }

  def findMissingNumberInRange3(arr: Array[Int], n: Int) = {
    var xor1, xor2 = 0

    for (i <- arr.indices) {
      xor1 = xor1 ^ arr(i)
      xor2 = xor2 ^ i+1
    }

    xor1 ^ xor2
  }

  //it may go out of memory if given int is 10^5. better to go with xor operation
  def findMissingNumberInRange2(arr: Array[Int], n: Int) = {
    val total = (n * (n + 1)) / 2
    var sum = 0
    for (i <- arr.indices) {
      sum = sum + arr(i)
    }
    total - sum
  }
}
