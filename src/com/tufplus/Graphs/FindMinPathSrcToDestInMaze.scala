package com.tufplus.Graphs

object FindMinPathSrcToDestInMaze {

  //maze has only 0/1 and if it is 1, add the dist as 1 moving from one cell to another.

  def findPath(input: Array[Array[Int]], source: Array[Int], destination: Array[Int]): Int = {
    val sourceX = source(0)
    val sourceY = source(1)

    val destinationX = destination(0)
    val destinationY = destination(1)

    val minPathDistance = -1

    val distArray = Array.fill(input.length, input(0).length)(Int.MaxValue)

    val queue = scala.collection.mutable.Queue[(Int, (Int, Int))]()
    queue.enqueue((0, (sourceX, sourceY)))

    val directions = Array((1, 0), (-1, 0), (0, 1), (0, -1))
    while (queue.nonEmpty) {
      val (currentDist, (currentX, currentY)) = queue.dequeue()
      directions.foreach {
        case (x, y) =>
          val newDistance = currentDist + 1
          val newLocationX = currentX + x
          val newLocationY = currentY + y

          if(newLocationX == destinationX && newLocationY == destinationY) return newDistance

          if (newLocationX >= 0 && newLocationX < input.length &&
            newLocationY >= 0 && newLocationY < input(0).length &&
            input(newLocationX)(newLocationY) == 1 &&
            distArray(newLocationX)(newLocationY) > newDistance) {
            queue.enqueue((newDistance, (newLocationX, newLocationY)))
            distArray(newLocationX)(newLocationY) = newDistance
          }

      }
    }
    minPathDistance
  }

}
