package com.tufplus.binarySearch

object FindKthPosition extends App {

  //Kth element of 2 sorted arrays
  //Input: a = [2, 3, 6, 7, 9], b = [1, 4, 8, 10], k = 5
  //Output: 6

  def findKthPosition(arr1: Array[Int], arr2: Array[Int], position: Int) = {

    def recurHelper(arr1: Array[Int], arr2: Array[Int], position: Int): Int = {
      if (position == 0) Math.min(arr1(0), arr2(0))
      else if (arr1.isEmpty) {
        if (arr2.length > position) arr2(position) else -1
      }
      else if (arr2.isEmpty) {
        if (arr1.length > position) arr2(position) else -1
      }
      else {
        val mid = position / 2
        val validIndex1 = Math.min(mid, arr1.length - 1)
        val validIndex2 = Math.min(mid, arr2.length - 1)
        println("arr1--" + arr1.toList + "--arr2--" + arr2.toList + "--mid--" + mid + "---position--"+ position)
        if (arr1(validIndex1) > arr2(validIndex2)) {
          recurHelper(arr1, if (mid == 0) arr2.drop(mid + 1) else arr2.drop(mid), if (mid == 0) position - (mid + 1) else position - mid)
        } else recurHelper(if (mid == 0) arr1.drop(mid + 1) else arr1.drop(mid), arr2, if (mid == 0) position - (mid + 1) else position - mid)
      }
    }

    recurHelper(arr1, arr2, position)
  }

  println(findKthPosition(Array(2, 3, 6, 7, 9), Array(1, 4, 8, 10), 7))


  def mergeTwoArrays(arr1: Array[Int], arr2: Array[Int]) = {
    var i, j = 0
    val res = scala.collection.mutable.ListBuffer[Int]()

    while (i <= arr1.length - 1 && j <= arr2.length - 1) {
      if (arr1(i) > arr2(j)) {
        res += arr2(j)
        j = j + 1
      } else {
        res += arr1(i)
        i = i + 1
      }
    }

    while (i < arr1.length) {
      res += arr1(i)
      i += 1
    }

    while (j < arr2.length) {
      res += arr2(j)
      j += 1
    }

    res
  }

  //println(mergeTwoArrays(Array(1, 2, 3, 4), Array(5)))
}
