object Main {
  def main(args: Array[String]): Unit = {

    def findMax1sCount(arr: List[Int]) = {
      var countOf1s, result = 0
      for (i <- arr.indices) {
        if (arr(i) == 1) {
          countOf1s = countOf1s + 1
          result = Math.max(result, countOf1s)
        } else {
          countOf1s = 0
        }
      }
    }

    def findMax1sCountFunctional(arr: List[Int]) = {
      val finalRes = arr.foldLeft((0, 0)) { case ((result, max1s), ele) =>
        if (ele == 1) {
          (result max (max1s + 1), max1s + 1)
        } else (result, 0)
      }._1
    }

    def moveZeros(arr: Array[Int]): Array[Int] = {
      var indexToWrite = 0
      for (i <- arr.indices) {
        if (arr(i) != 0) {
          arr(indexToWrite) = arr(i)
          indexToWrite = indexToWrite + 1
        }
      }
      for (j <- indexToWrite until arr.length) {
        arr(j) = 0
      }

      arr
    }

    //Input: nums = [0, 0, 3, 3, 5, 6]
    //Output: [0, 3, 5, 6, _, _]

    def findLeadersInArray2(arr: Array[Int]) =
      arr.foldRight((Int.MinValue, List[Int]())){case (el, acc) =>
        val (currentMax, leaders) = acc
        if(el > currentMax) (el, el :: leaders)
        else (currentMax, leaders)
      }._2


    def rearrange(nums: Array[Int]) = {
      var pos = 0
      var neg = 1
      val res = Array.fill(nums.length)(-1)

      for (i <- nums.indices) {
        if (nums(i) > 0) {
          res(pos) = nums(i)
          pos = pos + 2
        }else {
          res(neg) = nums(i)
          neg = neg + 2
        }
      }
      res
    }

    def getSpiralView(arr: List[List[Int]]) = {
      val numberOfRows = arr.length
      val numberOfColumns = arr.head.length
      var top, left = 0
      var bottom = numberOfRows - 1
      var right = numberOfColumns - 1

      while (top <= bottom && left <= right) {
        for (i <- left to right) {
          print(arr(top)(i))
        }
        top = top + 1

        for (i <- top to right) {
          print(arr(i)(right))
        }
        right = right - 1

        for (i <- if(right > left) right to left by -1 else right to left) {
          print(arr(bottom)(i))
        }
        bottom = bottom - 1

        //println("bottom--"+ bottom + "--top--"+ right)

        for (i <- if(bottom > top) bottom to top by -1 else bottom to top) {
          print(arr(i)(top))
        }
        left = left + 1

      }
    }

    println(rearrange(Array(2,3,4,-1,-2,-3)).toList)
    //println("Hello world!")
  }
}