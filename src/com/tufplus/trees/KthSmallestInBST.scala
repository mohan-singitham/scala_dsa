class TreeNode(_value: Int = 0, _left: TreeNode = null, _right: TreeNode = null) {
  var value: Int = _value
  var left: TreeNode = _left
  var right: TreeNode = _right
}
//inorder traversal will give a sorted array for BST
object  KthSmallestInBST {

  def kthSmallestInBST(node: TreeNode, k: Int) = {

    var count = 0
    var result = -1
    def inOrder(node: TreeNode): Unit = {
      if(node == null) return
      inOrder(node.left)
      count += 1
      if(count == k){
        result = node.value
        return
      }
      inOrder(node.right)
    }

    inOrder(node)
    result
  }

}