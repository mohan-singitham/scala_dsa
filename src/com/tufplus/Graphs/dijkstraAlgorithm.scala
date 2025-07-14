package com.tufplus.Graphs


object dijkstraAlgorithm {

  def getMinPaths(startNode: Int, adjacencyList: Map[Int, List[(Int, Int)]]) = {

    implicit val order: Ordering[(Int, Int)] = Ordering.by(_._1)
    val pq = scala.collection.mutable.PriorityQueue[(Int, Int)]()(order.reverse)

    val resArray = Array.fill(adjacencyList.keys.size)(Integer.MAX_VALUE)
    resArray(startNode) = 0

    pq.enqueue((0, startNode))

    while (pq.nonEmpty) {
      val (dist, currentNode) = pq.dequeue()
      val connectedSegments = adjacencyList.getOrElse(currentNode, List())

      connectedSegments.foreach { case (dist2, ele) =>
        if (resArray(ele) > dist + dist2) {
          pq.enqueue((dist + dist2, ele))
          resArray(ele) = dist + dist2
        }
      }
    }

    resArray
  }


}
