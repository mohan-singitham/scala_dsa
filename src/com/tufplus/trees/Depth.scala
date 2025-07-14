package com.tufplus.trees

import com.tufplus.trees.Tree.Node

object Depth {

  def depth(root: Node): Int = {
    root match {
      case Node(data, None, None) => 1
      case Node(data, left, right) =>
        val leftValue = left.map(depth).getOrElse(0)
        val rightValue = right.map(depth).getOrElse(0)
        val finalOut = math.max(leftValue, rightValue)
        finalOut
    }
  }

}
