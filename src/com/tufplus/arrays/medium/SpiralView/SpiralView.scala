package com.tufplus.arrays.medium.SpiralView

object SpiralView {

  def getSpiralView(arr: List[List[Int]]) = {
    val numberOfRows = arr.length
    val numberOfColumns = arr.head.length
    var top, left = 0
    var bottom = numberOfRows - 1
    var right = numberOfColumns - 1

    while (bottom < top && left < right) {
      for (i <- left to right) {
        print(arr(top)(i))
      }
      top = top + 1

      for (i <- top to right) {
        print(arr(i)(right))
      }
      right = right - 1

      for (i <- right to left) {
        print(arr(i)(bottom))
      }
      bottom = bottom - 1

      for (i <- bottom to top) {
        print(arr(i)(top))
      }
      left = left + 1

    }
  }
}
