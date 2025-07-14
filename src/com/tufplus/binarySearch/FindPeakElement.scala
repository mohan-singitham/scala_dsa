package com.tufplus.binarySearch

object FindPeakElement {

  def findPeakElement(arr: Array[Int]): Int = {
    val len = arr.length
    if (arr.length == 1) return 0
    else if (arr(0) > arr(1)) return 0
    else if (arr(len - 1) > arr(len - 2)) return len - 1
    else {
      var low = 1
      var high = len - 2

      while (low <= high) {
        val mid = low + (high - low) / 2
        if (arr(mid) > arr(mid - 1) && arr(mid) > arr(mid + 1)) return mid
        else if (arr(mid) > arr(mid - 1) && arr(mid) < arr(mid + 1)) {
          low = mid + 1
        }
        else high = mid - 1
      }
    }
    -1
  }
}
