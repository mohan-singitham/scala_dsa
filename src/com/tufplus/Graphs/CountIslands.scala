package com.tufplus.Graphs


import scala.collection.mutable.ListBuffer

object CountIslands {

  def countIslands(adjacencyList: Map[Int, List[Int]]) = {
    var count = 0
    val visited = ListBuffer[Int]()

    for (start <- adjacencyList.keys) {
      if (!visited.contains(start)) {
        dfsTraversal(start, adjacencyList, visited)
        count = count + 1
      }
    }
    count
  }

  def dfsTraversal(startNode: Int, adjacencyList: Map[Int, List[Int]], visited: ListBuffer[Int]): Unit = {
    val result = ListBuffer[Int]()
    if (!visited.contains(startNode)) {
      visited += startNode
      result += startNode
      val connectedNodes = adjacencyList.getOrElse(startNode, List())
      for (node <- connectedNodes) {
        if (!visited.contains(node)) {
          dfsTraversal(node, adjacencyList, visited)
        }
      }
    }
  }
}
