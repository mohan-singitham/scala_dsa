package com.tufplus.Graphs

import scala.collection.mutable.ListBuffer

object BFSTraversal {

  //BFS is level order
  def BFS(startNode: Int, adjacencyList: Map[Int, List[Int]]): Unit = {
    val result = ListBuffer[Int]()
    val visitedNodes = Set[Int]()
    val queue = scala.collection.mutable.Queue[Int](startNode)

    while (queue.nonEmpty) {
      val qDeq = queue.dequeue()
      if (!visitedNodes.contains(qDeq)) {
        visitedNodes ++= qDeq
        result += qDeq
        val connectedNodes = adjacencyList.getOrElse(qDeq, List())
        for (node <- connectedNodes) {
          if (!visitedNodes.contains(node)) {
            queue.enqueue(node)
          }
        }
      }
    }
    result.toList
  }
}
