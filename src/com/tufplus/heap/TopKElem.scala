package com.tufplus.heap

object TopKElem {

  def topKElem(input: Array[Int], k: Int) = {

    val mmap = scala.collection.mutable.Map[Int, Int]()
    input.foreach { el =>
      mmap(el) = mmap.getOrElse(el, 0) + 1
    }

    implicit val ordering: Ordering[(Int, Int)] = Ordering.by(_._2)
    val pqMinHeap = scala.collection.mutable.PriorityQueue[(Int, Int)]()(ordering.reverse)

    mmap.foreach { case (key, value) =>
      pqMinHeap.enqueue((key, value))
      if (pqMinHeap.size > k) {
        pqMinHeap.dequeue()
      }
    }
    pqMinHeap.map(_._1)
  }
}
