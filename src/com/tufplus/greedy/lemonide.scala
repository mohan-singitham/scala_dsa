package com.tufplus.greedy

object lemonide {

  //Input : bills = [5, 5, 10, 5, 20]
  //coins --> $5, $10, $20

  def lemonadeChange(bills: Array[Int]): Boolean = {
    var fives = 0
    var tens = 0

    for (bill <- bills) {
      if (bill == 5) {
        fives += 1
      } else if (bill == 10) {
        if (fives > 0) {
          fives -= 1
          tens += 1
        } else {
          return false
        }
      } else { // bill == 20
        if (tens > 0 && fives > 0) {
          tens -= 1
          fives -= 1
        } else if (fives >= 3) {
          fives -= 3
        } else {
          return false
        }
      }
    }
    true
  }
}
