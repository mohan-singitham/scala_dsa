/**
 * Definition for a binary tree node.
 * class TreeNode(_value: Int = 0, _left: TreeNode = null, _right: TreeNode = null) {
 *   var value: Int = _value
 *   var left: TreeNode = _left
 *   var right: TreeNode = _right
 * }
 */
object Solution {
  def isSameTree(p: TreeNode, q: TreeNode): Boolean = {
    (p, q) match {
      case (null, null) => true
      case (_, null) | (null, _) => false
      case _ => p.value == q.value && isSameTree(p.left, q.left) && isSameTree(p.right, q.right)
    }
  }
}

