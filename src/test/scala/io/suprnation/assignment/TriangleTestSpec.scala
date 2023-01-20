package io.suprnation.assignment

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

import scala.collection.immutable.List

class TriangleTestSpec extends AnyFlatSpec with Matchers {

  trait TestData:
    protected val triangle: Array[Array[Int]] = Array(
      Array(1),
      Array(1, 2),
      Array(1, 2, 3),
      Array(1, 2, 3, 4),
      Array(1, 2, 3, 4, 5)
    )
    protected val min: Int = 5
    protected val max: Int = 15

  "TrianglePath" should "calculate min path" in {
    new TestData {
      TrianglePath.min(triangle) shouldBe min
    }
  }

  "TrianglePath" should "calculate max path" in {
    new TestData {
      TrianglePath.max(triangle) shouldBe max
    }
  }

}
