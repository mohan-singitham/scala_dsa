//Given an integer array nums, return an array output where output[i] is the product of all the elements of nums except nums[i].
//
//Each product is guaranteed to fit in a 32-bit integer.
//
//Follow-up: Could you solve it in
//O
//(
//n
//)
//O(n) time without using the division operation?

object Product {

  //this will fail if zero are present
  def productExceptSelf(arr: Array[Int]) = {

    val finalProduct = arr.foldLeft(1)(_ * _)
    arr.map(x => finalProduct / x)

  }


  def productExceptSelf(arr: Array[Int]) = {
    val zerosCount = arr.count(_ == 0)
    val totalProduct = arr.filter(_ != 0).foldLeft(1)(_ * _)

    arr.map(x => if (zerosCount > 1) 0
    else if (zerosCount == 1) {
      if (x == 0) totalProduct else 0
    }
    else totalProduct / x
    )
  }
}