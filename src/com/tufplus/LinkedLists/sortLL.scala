package com.tufplus.LinkedLists

object sortLL {

  //Sort a LL of 0's 1's and 2's

  //Input: head -> 1 -> 0 -> 2 -> 0 -> 1
  //Output: head -> 0 -> 0 -> 1 -> 1 -> 2
  //Explanation: The values after sorting are [0, 0, 1, 1, 2].

  //we do not need to traverse the LL everytime. its good to track only head and last of every category.
  case class Node(data: Int, var next: Option[Node])

  def sortLinkedList(head: Option[Node]): Option[Node] = {

    var zerosPointerHead: Option[Node] = None
    var zerosPointerLast: Option[Node] = None

    var onesPointerHead: Option[Node] = None
    var onesPointerLast: Option[Node] = None

    var twosPointerHead: Option[Node] = None
    var twosPointerLast: Option[Node] = None

    var tmp = head

    while(tmp.isDefined){
      if(tmp.get.data == 0){
        if(zerosPointerHead.isEmpty) {
          zerosPointerHead = tmp
          zerosPointerLast = tmp
        }
        else{
          zerosPointerLast.get.next = tmp
          zerosPointerLast = tmp
        }
      }
      else if(tmp.get.data == 1){
        if(onesPointerHead.isEmpty) {
          onesPointerHead = tmp
          onesPointerLast = tmp
        }
        else{
          onesPointerLast.get.next = tmp
          onesPointerLast = tmp
        }
      }
      else {
        if(twosPointerHead.isEmpty) {
          twosPointerHead = tmp
          twosPointerLast = tmp
        }
        else{
          twosPointerLast.get.next = tmp
          twosPointerLast = tmp
        }
      }
      tmp = tmp.get.next
    }

    if(zerosPointerLast.isDefined) zerosPointerLast.get.next = onesPointerHead
    if(onesPointerLast.isDefined) onesPointerLast.get.next = twosPointerHead

    zerosPointerHead.orElse(onesPointerHead).orElse(twosPointerHead)
  }

}
