package com.tufplus.arrays.easy.movezeros

object MoveZeros {
  def moveZeros(arr: Array[Int]): Array[Int] = {
    var i = 0
    var j = 0

    while (j < arr.length && i < arr.length) {
      while (arr(i) != 0) {
        i = i + 1
      }
      while (arr(i) == 0) {
        j = j + 1
      }
      val temp = arr(j)
      arr(j) = arr(i)
      arr(i) = temp
    }
    arr
  }

  def moveZerosApproach2(arr: Array[Int]): Array[Int] = {
    var indexToWrite = 0
    for(i <- arr.indices){
      if(arr(i) != 0){
        arr(indexToWrite) = arr(i)
        indexToWrite = indexToWrite + 1
      }
    }
    for(j <- indexToWrite until arr.length){
      arr(j) = 0
    }

    arr
  }
}
