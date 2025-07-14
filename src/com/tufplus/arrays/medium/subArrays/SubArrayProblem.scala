package com.tufplus.arrays.medium.subArrays

object SubArrayProblem {
  def countSubstrings(s: String): Long = {
    val subStrings = (for (
      i <- 0 until s.length;
      j <- i + 1 to s.length
    ) yield s.substring(i, j)).toList

    val invalidCount = subStrings.count { str =>
      try {
        val num = str.toLong
        val firstNonZeroDigit = str.findLast(_ != '0').map(_.asDigit).getOrElse(1)
        num % firstNonZeroDigit != 0
      } catch {
        case _: NumberFormatException => false
      }
    }
    subStrings.length - invalidCount
  }
}

