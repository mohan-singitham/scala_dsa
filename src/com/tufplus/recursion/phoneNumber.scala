package com.tufplus.recursion

object phoneNumber extends App{
///Input : digits = "34"
  //Output : [ "dg", "dh", "di", "eg", "eh", "ei", "fg", "fh", "fi" ]
  //Explanation : The 3 is mapped with "def" and 4 is mapped with "ghi".

  def combinationsOnPhoneNumber(digits: Array[Int]) = {
    val finalRes = scala.collection.mutable.ListBuffer[List[String]]()
    val numberMap = Map(2 -> "def", 3 -> "ghi", 4 -> "jkl", 5 -> "mno", 6 -> "pqr", 7 -> "stu", 8 -> "vwx")
    def doRecur(index: Int, ans: List[String]): Unit = {
      println("index---"+ index + "--ans--"+ ans)
      if(index == digits.length){
        finalRes += ans
        return
      }
      val charArr = numberMap(digits(index) - '0').toCharArray
      for(ch <- charArr){
       doRecur(index+1, ans ++ List(ch.toString))
      }
    }

    doRecur(0, List())
    finalRes
  }

  println(combinationsOnPhoneNumber(Array('3', '4')))

}
