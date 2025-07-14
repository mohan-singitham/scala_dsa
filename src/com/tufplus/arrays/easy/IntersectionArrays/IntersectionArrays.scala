package com.tufplus.arrays.easy.IntersectionArrays

object IntersectionArrays {

  def intersectionArrays(arr1: Array[Int], arr2: Array[Int]) = {
    var i, j = 0
    val output = scala.collection.mutable.Set[Int]()
    while (i < arr1.length && j < arr2.length) {

      if (arr1(i) == arr2(j)) {
        output += arr1(i)
        i = i + 1
        j = j + 1
      } else if (arr1(i) < arr2(j)) {
        i = i + 1
      } else j = j + 1
    }
    output.toArray
  }
}
