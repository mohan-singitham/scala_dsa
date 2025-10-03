
object Symmetric {

  //https://leetcode.com/problems/symmetric-tree/
  class TreeNode(_value: Int = 0, _left: TreeNode = null, _right: TreeNode = null) {
       var value: Int = _value
       var left: TreeNode = _left
       var right: TreeNode = _right
    }

  def isSame(t1: TreeNode, t2: TreeNode): Boolean = {
    (t1, t2) match {
      case (null, null) => true
      case (_, null) | (null, _) => return false
      case _ => t1.value == t2.value && isSame(t1.left, t2.right) && isSame(t1.right, t2.left)
    }
  }


  def isSymmetric(root: TreeNode): Boolean = {
    if(root == null) true
    else isSame(root.left, root.right)
  }

}

