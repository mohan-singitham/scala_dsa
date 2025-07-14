package com.tufplus.Graphs

object FindCircle {

  def findCircle(arr: Map[Int, List[Int]], startNode: Int): Boolean = {

    val queue = scala.collection.mutable.Queue[(Int, Int)]()
    var visited = Set[Int]()
    queue.enqueue((startNode, -1))
    visited += startNode

    while (queue.nonEmpty) {
      val element = queue.dequeue()
      visited += element._1
      val connectedEle = arr(element._1)
      val filterConnected = connectedEle.filter(el => element._2 != el)

      if (filterConnected.exists(el => visited.contains(el))) return true
      else filterConnected.foreach(x => queue.enqueue((x, element._1)))
    }
    false
  }
}
