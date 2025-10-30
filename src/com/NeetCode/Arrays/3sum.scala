
object ThreeSum {

  //1.keep duplicates in mind and have while loops for j and k if they are duplicate
  //2. Keep in mind that we need to sort it before applying 2 pointer
  // j<k but not j<=k. if you have equal to you are allowing duplicate j and k with same value which is wrong

  def threeSum(arr1: Array[Int], target: Int) = {
    val result = scala.collection.mutable.ListBuffer[List[Int]]()
    val arr = arr1.sorted

    for (el <- arr.indices) {
      if (i == 0 || arr(el) != arr(el - 1)) {
        val firstEle = arr(el)
        var j = el + 1
        var k = arr.length - 1

        while (j < k) {
          val sum = firstEle + arr(j) + arr(k)
          if (sum == target) {
            result += List(firstEle, arr(j), arr(k))
            j += 1
            k -= 1

            while (j < k && arr(j) == arr(j - 1)) j += 1
            while (j < k && arr(k) == arr(k + 1)) k -= 1

          } else if (sum < target) {
            j += 1
          } else k -= 1
        }
      }
      result.toList.distinct
    }
  }

}