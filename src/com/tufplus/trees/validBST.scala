class TreeNode(_value: Int = 0, _left: TreeNode = null, _right: TreeNode = null) {
  var value: Int = _value
  var left: TreeNode = _left
  var right: TreeNode = _right
}

// Here we need to compare all the nodes to left are less than root node and all nodes to right are greater then root node
//so we need to maintain min and max bounds
//https://leetcode.com/problems/validate-binary-search-tree/
object validBST {

  def isValidBST(node: TreeNode) = {

    def helper(node: TreeNode, min: Long, max: Long): Boolean = {
      if(node == null) true
      else if(node.value <= min  || node.value >= max) return false
      else helper(node.left, min, node.value) && helper(node.right, node.value, max)
    }

    helper(node, Long.MinValue, Long.MaxValue)
  }

}