package com.tufplus.arrays.easy.unionArrays

object UnionArrays {

  //Given two sorted arrays nums1 and nums2, return an array that contains the union of these two arrays. The elements in the union must be in ascending order.

  //Example 1
  //Input: nums1 = [1, 2, 3, 4, 5], nums2 = [1, 2, 7]
  //Output: [1, 2, 3, 4, 5, 7]
  //Explanation: The elements 1, 2 are common to both, 3, 4, 5 are from nums1 and 7 is from nums2

  //Example 2
  //Input: nums1 = [3, 4, 6, 7, 9, 9], nums2 = [1, 5, 7, 8, 8]
  //Output: [1, 3, 4, 5, 6, 7, 8, 9]
  //Explanation: The element 7 is common to both, 3, 4, 6, 9 are from nums1 and 1, 5, 8 is from nums2

  //we can make result as set so that we need not look if it is already present as set will take care of that.
  def mergeTwoArrays(arr1: Array[Int], arr2: Array[Int]) = {
    var i, j = 0
    val result = scala.collection.mutable.ListBuffer[Int]()
    while (i < arr1.length && j < arr2.length) {
      if (arr1(i) <= arr2(j)) {
        if (!result.contains(arr1(i))) result += arr1(i)
        i = i + 1
      } else {
        if (!result.contains(arr2(j))) result += arr2(j)
        j = j + 1
      }
    }

    if (i == arr1.length && j < arr2.length) {
      for (k <- j until arr2.length) {
        if (!result.contains(arr2(k))) result += arr2(k)
      }
    }

    if (i < arr1.length && j == arr2.length) {
      for (k <- i until arr1.length) {
        if (!result.contains(arr1(k))) result += arr1(k)
      }
    }
    result.toArray
  }

  object Solution {
    def minTimeToVisitAllPoints(points: Array[Array[Int]]): Int = {
      var finalTime = 0
      points.toList.sliding(2).foreach {
        case List(Array(p1, p2), Array(p3, p4)) =>
          var diffX = if (p3 > p1) p3 - p1 else p1 - p3
          var diffY = if (p3 > p1) p4 - p2 else p2 - p4
          var diagonal = 0
          var up = 0
          var down = 0
          while (diffX > 0 && diffY > 0) {
            diffX -= 1
            diffY -= 1
            diagonal += 1
          }
          while (diffX != 0 || diffY != 0) {
            if (diffX < 0) {
              diffX += 1
              up += 1
            }
            else if(diffX > 0) {
              down -= 1
              diffX -= 1
            }
            if (diffY < 0) {
              up += 1
              diffY += 1
            }
            else if(diffY > 0) {
              down -= 1
              diffY -= 1
            }
          }
          val time = diagonal + up + down
          finalTime += time

        case List(Array(_), Array(_)) => finalTime
        case _ => finalTime
      }
      finalTime
    }
  }

}
