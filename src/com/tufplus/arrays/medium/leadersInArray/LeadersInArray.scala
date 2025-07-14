package com.tufplus.arrays.medium.leadersInArray

object LeadersInArray {

  def findLeadersInArray(arr: Array[Int]) = {
    var max = Int.MinValue
    val leaders = scala.collection.mutable.Set[Int]()
    for (i <- arr.indices.reverse) {
      if (arr(i) > max) {
        max = arr(i)
        leaders += max
      }
    }
    leaders.toArray
  }

  // functional way of writing
  def findLeadersInArray2(arr: Array[Int]) =
    arr.foldRight((Int.MinValue, List[Int]())) { case (el, acc) =>
      val (currentMax, leaders) = acc
      if (el > currentMax) (el, el :: leaders)
      else (currentMax, leaders)
    }._2
}


