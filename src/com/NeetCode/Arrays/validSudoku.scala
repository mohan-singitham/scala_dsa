
object validSudoku {

  def validSudoku(nums: Arrray[Array[Int]]) = {

    val rows = scala.collection.mutable.Map[Int, scala.collection.mutable.Set[Int]]()
    val columns = scala.collection.mutable.Map[Int, scala.collection.mutable.Set[Int]]()
    val squares = scala.collection.mutable.Map[Int, scala.collection.mutable.Set[Int]]()

    for (i <- 0 until nums.length) {
      for (j <- 0 until nums(0).length) {
        val value = nums(i)(j)

        if (rows.get(i).exists(_.contains(value))) return false
        if (columns.get(j).exists(_.contains(value))) return false
        val squarIndex = (i / 3) * 3 + (j / 3)
        if (squares.get(squarIndex).exists(_.contains(value))) return false
        rows(i).add(value)
        columns(j).add(value)
        squares(squarIndex).add(value)
      }
    }
    true
  }

}