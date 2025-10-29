
object TopKFrequentEle {

  def topKFrequentEle(nums: Array[Int], k: Int) = {
    val eleWithCount = nums
      .groupBy(el => el)
      .map { case (key, value) => (key, value.size) }
      .toList
      .sortBy(-_._2)

    eleWithCount.take(k).map(_._1)
  }

  //using max heap it is O(nlogK)
  def topKFrequentEle2(nums: Array[Int], k: Int) = {
    val freqMap = nums.groupBy(el => el).mapValues(_.size)
    val result = scala.collection.mutable.ListBuffer[Int]()
    val ord: Ordering[(Int, Int)] = Ordering.by(-_._2)
    val pq = scala.collection.mutable.PriorityQueue[(Int, Int)]()(ord)

    freqMap.foreach { case (key, value) => pq.enqueue((key, value)) }

    for (1 to k if pq.nonEmpty) {
      result += pq.dequeue()._1
    }
    result.toList
  }


}