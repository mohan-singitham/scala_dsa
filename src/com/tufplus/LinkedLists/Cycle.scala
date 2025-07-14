package com.tufplus.LinkedLists

object Cycle {

  case class Node(data: Int, next: Option[Node])

  def isCycle(head: Option[Node]): Boolean = {
    if (head.isEmpty) return false
    else {
      var slowPtr = head
      var fastPtr = head

      while(fastPtr.isDefined && fastPtr.head.next.isDefined){
        slowPtr = slowPtr.get.next
        fastPtr = fastPtr.get.next.get.next

        if(fastPtr.get.next.get.next.nonEmpty && slowPtr.get.data ==
          fastPtr.get.next.get.next.get.data) return true
      }
    }

    false
  }

}
