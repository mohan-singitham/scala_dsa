package com.tufplus.Graphs

object MinimumAdditionsToAchieveTarget {

  def getMinAdditionNeeded(source: Int, target: Int, array: Array[Int]): Int = {

    if(source < target) return -1
    val queue = scala.collection.mutable.Queue[(Int, Int)]()
    queue.enqueue((source, 0))

    val minDist = Array.fill(target + 1)(Integer.MAX_VALUE)

    while (queue.nonEmpty) {
      val (topEle, dist) = queue.dequeue()

      if (topEle == target) return dist

      array.zipWithIndex.foreach {
        ele =>
          val newAddition = ele._2 + topEle
          if (newAddition <= target) {
            queue.enqueue((newAddition, dist + 1))
            if (minDist(ele._1) > newAddition) minDist(ele._1) = newAddition
          }
      }

    }
    -1
  }

  //def getMinAdditionNeeded(source: Int, target: Int, array: Array[Int]): Int = {
  //
  //    // Input validation: Target cannot be less than source
  //    if (target < source) {
  //      return -1
  //    }
  //
  //    // A queue for BFS, storing tuples of (current_sum, steps_taken)
  //    val queue = Queue[(Int, Int)]()
  //
  //    // An array to store the minimum steps required to reach each possible sum from 'source' up to 'target'.
  //    // Initialized with Int.MaxValue to signify unvisited states.
  //    // The size is (target + 1) to cover all sums from 0 to target.
  //    val minSteps = Array.fill(target + 1)(Int.MaxValue)
  //
  //    // Start BFS from the source with 0 steps.
  //    queue.enqueue((source, 0))
  //    minSteps(source) = 0 // Mark source as visited with 0 steps.
  //
  //    // BFS loop
  //    while (queue.nonEmpty) {
  //      val (currentSum, steps) = queue.dequeue()
  //
  //      // If we reached the target, return the current steps.
  //      // Since it's BFS, the first time we reach the target, it's the minimum steps.
  //      if (currentSum == target) {
  //        return steps
  //      }
  //
  //      // Explore all possible next sums by adding elements from the 'array'
  //      for (addValue <- array) { // Iterate directly over the values in the array
  //        val newSum = currentSum + addValue
  //
  //        // Check bounds: newSum must not exceed target
  //        // Check if we found a shorter path to newSum than previously known
  //        if (newSum <= target && (steps + 1 < minSteps(newSum))) {
  //          // Update minSteps for the newSum
  //          minSteps(newSum) = steps + 1
  //          // Add the new state to the queue for further exploration
  //          queue.enqueue((newSum, steps + 1))
  //        }
  //      }
  //    }
  //
  //    // If the queue becomes empty and the target was not reached, it's unreachable.
  //    -1
  //  }

}
