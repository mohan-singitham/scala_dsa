package com.tufplus.Graphs

object MaxIslandSize {

  def MaxIslandSize(input: Array[Array[Int]]): Int = {
    val rows = input.length
    val columns = input(0).length
    val visited = Array.fill(rows, columns)(false)

    var maxSize = 0
    for (i <- input.indices) {
      for (j <- input(0).indices) {
        if (input(i)(j) == 1 && !visited(i)(j)) {
          val max = dfs(i, j, visited, input)
          maxSize = Math.max(max, maxSize)
        }
      }
    }
    maxSize
  }

  def dfs(i: Int, j: Int, visited: Array[Array[Boolean]], input: Array[Array[Int]]): Int = {
    if (i < 0 || i >= input.length || j < 0 || j >= input(0).length || input(i)(j) == 0 || visited(i)(j)) 0
    else {
      visited(i)(j) = true
      val directions = Array((1, 0), (0, 1), (-1, 0), (0, -1))
      var count = 1
      directions.foreach { case (xIndex, yIndex) =>
        val newX = i + xIndex
        val newY = j + yIndex
        if (newX >= 0 && newX < input.length && newY >= 0 && newY < input(0).length
          && input(newX)(newY) == 1 && !visited(newX)(newY)) {
          count += dfs(newX, newY, visited, input)
        }
      }
      count
    }
  }

}
