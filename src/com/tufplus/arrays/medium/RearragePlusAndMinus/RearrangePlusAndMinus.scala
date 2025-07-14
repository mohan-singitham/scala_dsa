package com.tufplus.arrays.medium.RearragePlusAndMinus

object RearrangePlusAndMinus {

  def rearrange(nums: Array[Int]) = {
    var pos = 0
    var neg = 1
    val res = Array.fill(nums.length)(-1)

    for (i <- nums.indices) {
      if (nums(i) > 0) {
        res(pos) = nums(i)
        pos = pos + 2
      }else {
        res(neg) = nums(i)
        neg = neg + 2
      }
    }
    res
  }

}
