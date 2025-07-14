package com.tufplus.Graphs

object FillXInOs {

  def fill(arr: Array[Array[Char]]): Array[Array[Char]] = {

    def dfs(i: Int, j: Int, visited: Array[Array[Boolean]], array: Array[Array[Char]]): Unit = {

      val directions = Array((0, 1), (-1, 0), (1, 0), (0, -1))
      visited(i)(j) = true

      for (direction <- directions) {
        val (indexOfX, indexOfY) = direction
        val newIndexX = i + indexOfX
        val newIndexY = j + indexOfY

        if (newIndexX >= 0 && newIndexX < arr.length && newIndexY >= 0 && newIndexY < arr(0).length &&
          !visited(newIndexX)(newIndexY) && array(newIndexX)(newIndexY) == 'O') {
          dfs(newIndexX, newIndexY, visited, array)
        }
      }
    }

    if(arr.length == 0 || arr(0).length == 0) return arr

    val visited = Array.fill[Boolean](arr.length, arr(0).length)(false)
    val rows = arr.length
    val columns = arr(0).length
    //traverse first row and last rows
    for (i <- 0 until columns) {
      if (arr(0)(i) == 'O') {
        dfs(0, i, visited, arr)
      }
      if (arr(rows - 1)(i) == 'O') {
        dfs(i, 0, visited, arr)
      }
    }

    //first column and last column
    for (i <- 0 until rows) {
      if (arr(i)(0) == 'O') {
        dfs(i, 0, visited, arr)
      }
      if (arr(i)(columns - 1) == 'O') {
        dfs(arr.length - 1, i, visited, arr)
      }
    }

    for (i <- arr.indices) {
      for (j <- arr(0).indices) {
        if (arr(i)(j) == 'O' && !visited(i)(j)) {
          arr(i)(j) = 'X'
        }
      }
    }
    arr
  }

}
