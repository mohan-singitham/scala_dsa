package com.tufplus.heap

object MergeKLists {

  case class ListNode(value: Int, var nextData: ListNode = null)

  def mergeKLists(lists: List[ListNode]) = {

    implicit val ordering: Ordering[ListNode] = Ordering.by(_.value)
    val pq = scala.collection.mutable.PriorityQueue[ListNode]()(ordering.reverse)

    val dummy = ListNode(0)
    for (list <- lists if list != null) {
      pq.enqueue(list)
    }

    var current = dummy

    while (pq.nonEmpty) {
      val data = pq.dequeue()
      current.nextData = data
      current = current.nextData
      if (data.nextData != null) {
        pq.enqueue(data.nextData)
      }
    }

    dummy.nextData

  }


  def mergeLists(lists: List[List[Int]]) = {
    implicit val ordersing: Ordering[(Int, Int, Int)] = Ordering.by[(Int, Int, Int), Int](_._1).reverse
    val heap = scala.collection.mutable.PriorityQueue.empty[(Int, Int, Int)]
    val result = scala.collection.mutable.ListBuffer[Int]()
    lists.zipWithIndex.foreach { case (list, listIndex) => heap.enqueue((list.head, listIndex, 0)) }

    while (heap.nonEmpty) {
      val (element, listIndex, eleIndex) = heap.dequeue()
      result += element

      if (eleIndex + 1 < lists(listIndex).length) {
        heap.enqueue((lists(listIndex)(eleIndex + 1), listIndex, eleIndex + 1))
      }
    }
    result.toList
  }

}
