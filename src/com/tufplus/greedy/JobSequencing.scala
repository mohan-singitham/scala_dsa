package com.tufplus.greedy

object JobSequencing {

  //Input : Jobs = [ [1, 4, 20] , [2, 1, 10] , [3, 1, 40] , [4, 1, 30] ]
  // Maximise the profit
  //Output : 2 60

  def maximizeProfit(jobs: Array[Array[Int]]) = {
    val profitOrder = jobs.sortBy(arr => arr(2))(Ordering.Int.reverse)

    val maxDalays = jobs.map(arr => arr(1)).max
    val tmp = Array.fill(maxDalays)(-1)
    var maxProfit = 0
    var jobsDone = 0
    for (arr <- profitOrder) {
      var status = true
      for (j <- arr(1) - 1 to 0 by -1) {
        if (tmp(j) == -1 && status) {
          tmp(j) = arr(0)
          maxProfit += arr(2)
          jobsDone += 1
          status = false
        }
      }
    }
    maxProfit
  }


  def maxActivities(activities: List[(Int, Int)]): List[(Int, Int)] = {
    val sortedActivities = activities.sortBy(_._2) // Sort by end time
    sortedActivities.foldLeft(List[(Int, Int)]()) { case (acc, el) =>
      if (acc.isEmpty || acc.last._2 < el._1) acc :+ el
      else acc
    }
  }
}
