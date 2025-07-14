package com.tufplus.Graphs

object FloodFill {

  def floodFill(adjacencyList: Array[Array[Int]], xVal: Int, yVal: Int, newColor: Int): Unit = {
    val colourOfStart = adjacencyList(xVal)(yVal)
    if(colourOfStart == newColor) return
    val visited = Array.fill(adjacencyList.length, adjacencyList(0).length)(false)
    visited(xVal)(yVal) = true
    adjacencyList(xVal)(yVal) = newColor
    goDFS(xVal, yVal, adjacencyList, newColor, colourOfStart, visited)
    printAdjacency(adjacencyList)
  }

  def goDFS(i: Int, j: Int, adjacencyList: Array[Array[Int]], newColour: Int, initialColor: Int, visited: Array[Array[Boolean]]): Unit = {

    val directions = Array((1, 0), (0, 1), (-1, 0), (0, -1))

    directions.foreach { dir =>
      val nextI = i + dir._1
      val nextJ = j + dir._2
      if (nextI >= 0 && nextI < adjacencyList.length && nextJ >= 0 && nextJ < adjacencyList(0).length
        && !visited(nextI)(nextJ) &&
        adjacencyList(nextI)(nextJ) == initialColor) {
        visited(nextI)(nextJ) = true
        adjacencyList(nextI)(nextJ) = newColour
        goDFS(nextI, nextJ, adjacencyList, newColour, initialColor, visited)
      }
    }
  }

  def printAdjacency(adjacencyList: Array[Array[Int]]) = {
    for (i <- adjacencyList.indices) {
      for (j <- adjacencyList(0).indices) {
        print(adjacencyList(i)(j))
      }
      println("\n")
    }
  }
}
