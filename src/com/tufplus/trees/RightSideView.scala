class TreeNode(_value: Int = 0, _left: TreeNode = null, _right: TreeNode = null) {
  var value: Int = _value
  var left: TreeNode = _left
  var right: TreeNode = _right
}
//https://leetcode.com/problems/binary-tree-right-side-view/
object views {
  def rightSideView(node: TreeNode): List[Int] = {
    if (node == null) List()
    else {
      val listBuff = scala.collection.mutable.ListBuffer[Int]()
      val queue = scala.collection.mutable.Queue[TreeNode]()
      queue.enqueue(node)

      while (queue.nonEmpty) {
        val size = queue.size

        for (i <- 0 until size) {
          val node = queue.dequeue()
          if (node.left != null) queue.enqueue(node.left)
          if (node.right != null) queue.enqueue(node.right)
          if(i == size - 1) listBuff += node.value
        }
      }
      listBuff.toList
    }
  }

  def leftSideView(node: TreeNode): List[Int] = {
    if (node == null) List()
    else {
      val listBuff = scala.collection.mutable.ListBuffer[Int]()
      val queue = scala.collection.mutable.Queue[TreeNode]()
      queue.enqueue(node)

      while (queue.nonEmpty) {
        val size = queue.size

        for (i <- 0 until size) {
          val node = queue.dequeue()
          if (node.left != null) queue.enqueue(node.left)
          if (node.right != null) queue.enqueue(node.right)
          if(i == 0) listBuff += node.value
        }
      }
      listBuff.toList
    }
  }



}
