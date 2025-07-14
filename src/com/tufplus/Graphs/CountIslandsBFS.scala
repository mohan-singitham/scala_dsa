package com.tufplus.Graphs

object CountIslandsBFS {

  def countIslandsBFS(arr: Array[Array[Int]]) = {

    val rows = arr.length
    val columns = arr(0).length
    val visited = Array.fill[Boolean](rows, columns)(false)
    var count = 0

    val queue = scala.collection.mutable.Queue[(Int, Int)]()
    val directionsToCheck = Array((1, 0), (0, 1), (-1, 0), (0, -1))

    def callBFS(): Unit = {
      while (queue.nonEmpty) {
        val (current_i, current_j) = queue.dequeue()
        directionsToCheck.foreach { case (ii, jj) =>
          val updatedFirstIndex = current_i + ii
          val updatedSecondIndex = current_j + jj
          if (updatedFirstIndex >= 0 && updatedFirstIndex <= rows - 1 &&
            updatedSecondIndex >= 0 && updatedSecondIndex <= columns - 1 &&
            !visited(updatedFirstIndex)(updatedSecondIndex) &&
            arr(updatedFirstIndex)(updatedSecondIndex) == 1) {
            visited(updatedFirstIndex)(updatedSecondIndex) = true
            queue.enqueue((updatedFirstIndex, updatedSecondIndex))
          }
        }
      }
    }


    for (i <- 0 until rows) {
      for (j <- 0 until columns) {
        if (!visited(i)(j) && arr(i)(j) == 1) {
          visited(i)(j) = true
          queue.enqueue((i, j))
          callBFS()
          count += 1
        }
      }
    }
    count
  }

}
