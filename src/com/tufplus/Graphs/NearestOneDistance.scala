package com.tufplus.Graphs

object NearestOneDistance {

  def nearestOneDistance(input: Array[Array[Int]]) = {
    val rows = input.length
    val columns = input(0).length
    val queue = scala.collection.mutable.Queue[((Int, Int), Int)]()

    val visited = Array.fill[Boolean](rows, columns)(false)
    val distanceArray = Array.fill[Int](rows, columns)(-1)
    val directions = Array((0, 1), (0, -1), (1, 0), (-1, 0))

    for (i <- 0 until rows) {
      for (j <- 0 until columns) {
        if (input(i)(j) == 1) {
          visited(i)(j) = true
          distanceArray(i)(j) = 0
          queue.enqueue(((i, j), 0))
        }
      }
    }

    while (queue.nonEmpty) {
      val eleOnQue = queue.dequeue()
      val (xIndex, yIndex) = (eleOnQue._1._1, eleOnQue._1._2)
      val distance = eleOnQue._2

      directions.foreach { case (x, y) =>
        val newIndexForX = xIndex + x
        val newIndexForY = yIndex + y
        if (newIndexForX >= 0 && newIndexForX < rows && newIndexForY >= 0
          && newIndexForY < columns && !visited(newIndexForX)(newIndexForY)
          && input(newIndexForX)(newIndexForY) == 0) {
          visited(newIndexForX)(newIndexForY) = true
          distanceArray(newIndexForX)(newIndexForY) = distance + 1
          queue.enqueue(((newIndexForX, newIndexForY), distance + 1))
        }
      }
    }
    distanceArray
  }

}
