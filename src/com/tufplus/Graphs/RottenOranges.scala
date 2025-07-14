package com.tufplus.Graphs

object RottenOranges {

  def getRottenOranges(input: Array[Array[Int]]) = {
    val rows = input.length
    val columns = input(0).length
    val visited = Array.fill(rows, columns)(false)
    val directions = Array((-1, 0), (1, 0), (0, -1), (0, 1))
    val queue = scala.collection.mutable.Queue[(Int, Int)]()
    var freshOranges = 0
    var minutes = 0


    for (i <- 0 until rows; j <- 0 until columns) {
      if (input(i)(j) == 2) {
        queue.enqueue((i, j))
      }else if(input(i)(j) == 1){
        freshOranges += 1
      }
    }

    while(queue.nonEmpty && freshOranges > 0){
      val (rottenX, rottenY) = queue.dequeue()
      directions.foreach { case (x, y) =>
        val newX = rottenX + x
        val newY = rottenY + y
        if (newX >= 0 && newX < input.length && newY >= 0 && newY < input(0).length
          && input(newX)(newY) == 1) {
          freshOranges -= 1
          queue.enqueue((newX, newY))
        }
      }
      minutes += 1
    }

    if(freshOranges > 0) -1 else minutes
  }
}
