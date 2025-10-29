//Given a string s, return true if it is a palindrome, otherwise return false.
//
//A palindrome is a string that reads the same forward and backward. It is also case-insensitive and ignores all non-alphanumeric characters.
//
//Note: Alphanumeric characters consist of letters (A-Z, a-z) and numbers (0-9).
//
//Example 1:
//
//Input: s = "Was it a car or a cat I saw?"
//
//Output: true


object ValidPalendrome {

  def validPalendrome(input: String) = {

    val smallLetters = ('a' to 'z').toList
    val capitalLetters = ('A' to 'Z').toList
    val numbers = Range(1, 9).toList
    val res = new StringBuilder()

    input.foreach(el =>
      if(smallLetters.contains(el) || capitalLetters.contains(el) || numbers.contains(el)){
       res.append(el.toString.toLowerCase)
      }
    )
    isPalendrome(res)
  }


  def isPalendrome(str: String) = {
    var i = 0
    var j = str.length - 1

    while(i <= j){
      if(str(i) != str(j)) return false
      else {
        i+=1
        j-=1
      }
    }
    true
  }


}