package com.tufplus.LinkedLists

object RemoveNthEleFromList {

  //Input: head -> 1 -> 2 -> 3 -> 4 -> 5, n = 2
  //Output: head -> 1 -> 2 -> 3 -> 5
  //Explanation: The 2nd node from the back was the node with value 4.

  case class Node(data: Int, var next: Option[Node])

  def removeNthElementFromBack(head: Option[Node], position: Int): Option[Node] = {

    var fastPtr: Option[Node] = head
    var slowPtr: Option[Node] = head

    for (i <- 0 until position) {
      if (fastPtr.isDefined) fastPtr = fastPtr.get.next
    }

    while (fastPtr.isDefined && fastPtr.get.next.nonEmpty) {
      if (slowPtr.isDefined) slowPtr = slowPtr.get.next
      if (fastPtr.isDefined) fastPtr = fastPtr.get.next
    }

    if(fastPtr.isEmpty) return head.get.next

    slowPtr = slowPtr.get.next.get.next
    head
  }


}
