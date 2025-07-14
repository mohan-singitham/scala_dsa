package com.tufplus.arrays.easy.Stock

object BuyStock {
  //we dont need stack at all as we are just keeping what is the max till that point
  // we need stack only if we need more info for each element what is the next max/min problems
  def maxProfit(prices: Array[Int]): Int = {
    val stack = scala.collection.mutable.Stack[Int]()
    var maxProfit = 0
    var diff = 0
    for (i <- prices.length - 1 to 0 by -1) {
      if (stack.isEmpty) stack.push(prices(i))
      else {
        if (prices(i) < stack.top) {
          diff = stack.top - prices(i)
          maxProfit = Math.max(maxProfit, diff)
        } else {
          stack.pop()
          stack.push(prices(i))
        }
      }
    }
    maxProfit
  }


  def maxProfit2(prices: Array[Int]): Int = {
    var maxTillNow = Int.MinValue
    var maxDiff = 0
    for (i <- prices.length - 1 to 0 by -1) {
      maxTillNow = Math.max(maxTillNow, prices(i))
      maxDiff = Math.max(maxTillNow - prices(i), maxDiff)
    }
    maxDiff
  }

}
