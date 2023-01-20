package io.suprnation.assignment

object TrianglePath:
  def min(ints: Array[Array[Int]]): Int =
    var result = 0
    var i = 0
    while (i < ints.length) {
      var minimum = Int.MaxValue

      var j = 0
      while (j <= i) {

        if (i == 0 && j == 0) {
          minimum = Math.min(minimum, ints(i)(j))
        } else if (i == j) {
          ints(i)(j) = ints(i)(j) + ints(i - 1)(j - 1)
          minimum = Math.min(minimum, ints(i)(j))
        } else {
          var up, down = ints(i)(j)
          
          if (j > 0) {
            up = up + ints(i - 1)(j - 1)
          } else {
            up = Int.MaxValue
          }

          down = down + ints(i - 1)(j)
          ints(i)(j) = Math.min(up, down)

          minimum = Math.min(minimum, ints(i)(j))
        }

        j = j + 1
      }
      result = minimum
      i = i + 1
    }
    result

  def max(ints: Array[Array[Int]]): Int =
    var result = 0
    var i = 0
    while (i < ints.length) {
      var maximum = Int.MinValue

      var j = 0
      while (j <= i) {

        if (i == 0 && j == 0) {
          maximum = Math.max(maximum, ints(i)(j))
        } else if (i == j) {
          ints(i)(j) = ints(i)(j) + ints(i - 1)(j - 1)
          maximum = Math.max(maximum, ints(i)(j))
        } else {
          var up, down = ints(i)(j)

          if (j > 0) {
            up = up + ints(i - 1)(j - 1)
          } else {
            up = Int.MinValue
          }

          down = down + ints(i - 1)(j)
          ints(i)(j) = Math.max(up, down)

          maximum = Math.max(maximum, ints(i)(j))
        }

        j = j + 1
      }
      result = maximum
      i = i + 1
    }
    result
