package com.tufplus.arrays.easy.ReversePairs

object ReversePairs {

  def reversePairs(arr: Array[Int]) = {
    var counter = 0
    for (i <- arr.indices) {
      for (j <- i + 1 until arr.length) {
        if (arr(i) > 2 * arr(j)) counter += 1
      }
    }
    counter
  }
}
