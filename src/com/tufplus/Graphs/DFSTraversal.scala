package com.tufplus.Graphs

import scala.collection.mutable.ListBuffer

object DFSTraversal {

  def DFS(startNode: Int, adjacencyList: Map[Int, List[Int]]): Unit = {
    val result = ListBuffer[Int]()
    val visited = ListBuffer[Int]()

    def dfsHelper(node: Int): Unit = {
      if(!visited.contains(node)){
        visited += node
        result += node
        val connected = adjacencyList.getOrElse(node, List())
        for(node <- connected){
          if(!visited.contains(node)){
            dfsHelper(node)
          }
        }
      }
    }

    dfsHelper(startNode)
  }

}
