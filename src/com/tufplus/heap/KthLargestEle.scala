package com.tufplus.heap

object KthLargestEle {
  //val nums = Array(3, 2, 1, 5, 6, 4)
  //val k = 2
  def kthLargestEle(nums: Array[Int], k: Int) = {
    val pq = scala.collection.mutable.PriorityQueue[Int]()(Ordering.Int.reverse)

    for(el <- nums){
      pq.enqueue(el)
      if(pq.size > k){
        pq.dequeue()
      }
    }

    pq.head //kth largest

  }

}
