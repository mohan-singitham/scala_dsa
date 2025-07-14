package com.tufplus.LinkedLists

class LinkedListImpl[A] {
  case class Node(var data: A, var next: Option[Node] = None)

  private var head: Option[Node] = None
  var size = 0

  def insertNode(data: A) = {
    val newNode = new Node(data)

    if(head.isEmpty) head = Some(newNode)
    else {
      var current = head
      while(current.get.next.nonEmpty){
        current = current.get.next
      }
      current.get.next = Some(newNode)
    }
  }

  def isEmpty = head.isEmpty

  def reverse() = {
    var prev: Option[Node] = None
    var current = head

    while(current.isDefined){
      val next = current.get.next
      current.get.next = prev
      prev = current
      current = next
    }

    head = prev
  }


}
