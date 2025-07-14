package com.tufplus.trees

object Tree {

  case class Node(data: Int, var left: Option[Node], var right: Option[Node])

  var root: Option[Node] = None

  def inOrder(root: Option[Node]): Unit = {
    root match {
      case None => ()
      case Some(node) =>
        inOrder(node.left)
        println(node.data)
        inOrder(node.right)
    }
  }

  def preOrder(root: Option[Node]): Unit = {
    root match {
      case None => ()
      case Some(node) =>
        println(node.data)
        preOrder(node.left)
        preOrder(node.right)
    }
  }

  def postOrder(root: Option[Node]): Unit = {
    root match {
      case None => ()
      case Some(node) =>
        preOrder(node.left)
        preOrder(node.right)
        println(node.data)
    }
  }

}
