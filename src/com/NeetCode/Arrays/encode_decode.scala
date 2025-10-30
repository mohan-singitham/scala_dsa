

object encode_decode {

  def encode(arr: Array[String]): String = {

    arr.mkString("|")

  }

  def decode(str: String): Array[String] = {

    str.split("\\|").toArray

  }


  def encode2(arr: Array[String]): String = {

    val sb = new StringBuilder()
    for (str <- arr) {
      sb.append(str.length).append("#").append(str)
    }
    sb.toString()
  }


  //if we store the length of the word and some delimiter, we can easily take
  // those length and get even that delimiter is present else where.
  def decode2(str: String): Array[String] = {

    var i = 0
    val result = scala.collection.mutable.ListBuffer[String]()

    while (i < str.length) {
      var j = i
      while (str(j) != '#') j += 1
      val length = str.substring(i, j).toInt
      val word = str.substring(j + 1, j + 1 + length)
      result += word
      i = j + 1 + length
    }
    result.toArray
  }