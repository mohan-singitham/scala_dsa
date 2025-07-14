package com.tufplus.binarySearch

object KokoBananas {

  //Input: n = 4, nums = [7, 15, 6, 3], h = 8
  def minimumRateToEatBananas(nums: Array[Int], h: Int): Int = {
    val maxEle = nums.max
    var minimumToEat = maxEle

    def calTotalHours(numberOfBananasPerHr: Int) = {
      var totalTime = 0
      for (i <- nums) {
        totalTime += Math.ceil(i / numberOfBananasPerHr)
      }
      totalTime
    }

    for (i <- 1 to maxEle) {
      val result = calTotalHours(i)
      if(result <= h){
        minimumToEat = result
        return minimumToEat
      }
    }
     minimumToEat
  }
}
