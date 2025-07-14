package com.tufplus.arrays.easy.RepeatedNumber

import scala.collection.mutable.ListBuffer

object RepeatedNumber {

  def repeatedNumber(arr: Array[String]) = {

    arr.foldLeft((List[Int](), List[Int]())){(acc, el) => {
      val (allElements, res) = acc
      if(allElements.contains(el)) (allElements, res :+ el)
      else (allElements :+ el, res)
    }}._2

    val mmap = scala.collection.mutable.Map[String, Int]()
    val repeatedList = ListBuffer[String]()
    for(el <- arr){
      if(mmap.contains(el)) repeatedList += el
      else mmap += (el, 1)
    }
    repeatedList.toList
  }





}
