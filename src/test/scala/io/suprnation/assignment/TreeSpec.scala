package io.suprnation.assignment

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

import scala.collection.immutable.List

class TreeSpec extends AnyFlatSpec with Matchers {

  private val triangle = Array(
    Array(1),
    Array(1, 2),
    Array(1, 2, 3),
    Array(1, 2, 3, 4),
    Array(1, 2, 3, 4, 5)
  )

  "TrianglePath" should "calculate min path" in {
    TrianglePath.min(triangle) shouldBe 5
  }

  "TrianglePath" should "calculate max path" in {
    TrianglePath.max(triangle) shouldBe 15
  }

}
