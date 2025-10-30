
object WaterContainer {

  def waterContainerArea(heights: Array[Int]): Int = {
    var i = 0
    var j = heights.length - 1
    var maxArea = 0
    while (i < j) {
      val width = j - i
      val area = width * Math.min(heights(i), heights(j))
      maxArea = Math.max(maxArea, area)
      if (heights(i) < heights(j)) i += 1
      else j -= 1
    }
    maxArea
  }

}