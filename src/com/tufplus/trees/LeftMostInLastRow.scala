
// Definition for a binary tree node.
class TreeNode(_value: Int = 0, _left: TreeNode = null, _right: TreeNode = null) {
  var value: Int = _value
  var left: TreeNode = _left
  var right: TreeNode = _right
}

//https://leetcode.com/problems/find-bottom-left-tree-value/submissions/1790794963/

/*
1. define a queue and insert the root first
2. iterate till queue is empty
3. for each node we insert left and right nodes. so first element is always the left child. so if i ==0 it is saying we are on left
First insert the root
 */

object Solution {
  def findBottomLeftValue(root: TreeNode): Int = {
    val queue = scala.collection.mutable.Queue[TreeNode]()
    queue.enqueue(root)
    var leftMost = root.value

    while (queue.nonEmpty) {
      val queueSize = queue.size
      for (i <- 0 until queueSize) {
        val node = queue.dequeue()
        if (i == 0) leftMost = node.value
        if (node.left != null) queue.enqueue(node.left)
        if (node.right != null) queue.enqueue(node.right)
      }
    }
    leftMost
  }
}