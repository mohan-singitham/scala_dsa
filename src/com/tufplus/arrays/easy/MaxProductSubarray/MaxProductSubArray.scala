package com.tufplus.arrays.easy.MaxProductSubarray

object MaxProductSubArray {

  //[2,3,-2,4]
  // we do from left to right once we call it as prefix
  //we do from right to left we call it as suffix
  //because if -ve number exists in the first, product will be -ve. so we do from back as well
  //which ever has max we take that and move ahead.
  def getMaxProductSubArray(arr: Array[Int]) = {
    var prefix = 1
    var suffix = 1
    var maxProduct = Integer.MIN_VALUE

    for(i <- arr.indices){
      if(prefix == 0) prefix = 1
      if(suffix == 0) suffix = 1

      prefix = prefix * arr(i)
      suffix = suffix * arr(arr.length - i - 1)

      maxProduct = Math.max(maxProduct, Math.max(prefix, suffix))
    }
  }
}
