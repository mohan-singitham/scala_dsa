package com.tufplus.LinkedLists

object NumberToLinkedList {

  case class Node(var data: Int, var next: Option[Node] = None)

  class LinkedList {

    var head: Option[Node] = None

    def insert(data: Int) = {
      if (head.isEmpty) {
        head = Some(Node(data, None))
      } else {
        var tmp = head
        while (tmp.nonEmpty && tmp.get.next.nonEmpty) {
          tmp = tmp.get.next
        }
        tmp.get.next = Some(Node(data, None))
      }
    }

    def reverse() = {
      var prev: Option[Node] = None
      var current = head
      while (current.nonEmpty) {
        val next = current.get.next
        current.get.next = prev
        prev = current
        current = next
      }
      head = prev
    }

    def printList = {
      val list = scala.collection.mutable.ListBuffer[Int]()
      var tmp = head
      while (tmp.nonEmpty) {
        list += tmp.get.data
        tmp = tmp.get.next
      }
      list.mkString("-->")
    }

    def addNumberToLinkedList() = {
      val carry = helper(head)
      if(carry == 0){
        head
      }
      head
    }
  }

  def convertNumberToLinkedList(number: Int) = {
    val linkedList = new LinkedList()
    val numlist = number.toString.map(_.asDigit).toList
    numlist.map(num => linkedList.insert(num))
    linkedList.printList
  }

  def helper(node: Option[Node]): Int = {
    node match {
      case Some(nodew) =>
        val carry = helper(nodew.next)
        node.get.data = node.get.data + carry
        if (node.get.data < 10) 0
        else {
          node.get.data = 0
          1
        }
      case None => 1
    }
  }

  def main(args: Array[String]) = {
    //print(convertNumberToLinkedList(123))

    val ll = new LinkedList()
    ll.insert(1)
    ll.insert(2)
    ll.insert(3)
    ll.addNumberToLinkedList()
    print(ll.printList)
  }
}
