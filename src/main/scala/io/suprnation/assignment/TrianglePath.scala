package io.suprnation.assignment

object TrianglePath:
  
  private def traversMtrx(ints: Array[Array[Int]], init: Int, compare: (Int, Int) => Int): Int =
    var result = 0
    var i = 0
    while (i < ints.length) {
      var tmpResult = init

      var j = 0
      while (j <= i) {

        if (i == 0 && j == 0) {
          tmpResult = compare(tmpResult, ints(i)(j))
        } else if (i == j) {
          ints(i)(j) = ints(i)(j) + ints(i - 1)(j - 1)
          tmpResult = compare(tmpResult, ints(i)(j))
        } else {
          var up, down = ints(i)(j)

          if (j > 0) {
            up = up + ints(i - 1)(j - 1)
          } else {
            up = init
          }

          down = down + ints(i - 1)(j)
          ints(i)(j) = compare(up, down)

          tmpResult = compare(tmpResult, ints(i)(j))
        }

        j = j + 1
      }
      result = tmpResult
      i = i + 1
    }
    result
  
  def min(ints: Array[Array[Int]]): Int =
    traversMtrx(ints, Int.MaxValue, Math.min)

  def max(ints: Array[Array[Int]]): Int =
    traversMtrx(ints, Int.MinValue, Math.max)
