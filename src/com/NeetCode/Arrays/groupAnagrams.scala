
object groupAnagrams {

  def groupAnagram(arr: List[String]): List[List[String]] = {

    val sortedMap = arr.map(el => (el.sorted, el)).groupBy(_._1).mapValues(_.map(_._2))
    sortedMap.map{case (key, value) => value.toList}.toList

  }

  def groupAnagram2(arr: List[String]): List[List[String]] = {
    arr.groupBy(_.sorted).values.toList
  }

}