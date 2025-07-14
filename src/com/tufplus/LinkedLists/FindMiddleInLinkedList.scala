package com.tufplus.LinkedLists

object FindMiddleInLinkedList {

  case class Node[A](data: A, var next: Option[Node[A]] = None)

  def findMiddleElement[A](head: Option[Node[A]]): Option[Node[A]] = {
    if (head.isEmpty || head.exists(_.next.isEmpty)) head
    else {
      var slow = head
      var fast = head
      while (fast.nonEmpty || fast.exists(_.next.nonEmpty)) {
        slow = slow.get.next
        fast = fast.get.next.get.next
      }
      slow
    }
  }


  //Node(1, Node(2, Node(4, Node(5, None)))))
}
