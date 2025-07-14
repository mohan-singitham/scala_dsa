package com.tufplus.Graphs

object FindMinimumPathFromSourceToDest {

  def findPath(source: Int, dest: Int, adjacency: Map[Int, List[(Int, Int)]]) = {

    val minDistanceArray = Array.fill(adjacency.keys.size + 1)(Integer.MAX_VALUE)
    minDistanceArray(source) = 0

    val parentArray = Array.fill(adjacency.keys.size + 1)(Integer.MAX_VALUE)
    parentArray(source) = source

    implicit val ordering: Ordering[(Int, Int)] = Ordering.by(_._1)
    val minHeap = scala.collection.mutable.PriorityQueue[(Int, Int)]()(ordering.reverse)

    minHeap.enqueue((0, source))

    while (minHeap.nonEmpty) {
      val (dist, node) = minHeap.dequeue()
      val connectedSeg = adjacency.getOrElse(node, List())

      connectedSeg.foreach { case (dist2, node2) =>
        if (dist + dist2 < minDistanceArray(node2)) {
          minDistanceArray(node2) = dist2 + dist
          minHeap.enqueue((dist2+ dist, node2))
          parentArray(node2) = node
        }
      }
    }

    var destination = dest
    val resultPath = scala.collection.mutable.ListBuffer[Int]()

    while(parentArray(destination) != destination) {
      resultPath += destination
      destination = parentArray(destination)
    }

    resultPath.reverse.toList
  }

}
