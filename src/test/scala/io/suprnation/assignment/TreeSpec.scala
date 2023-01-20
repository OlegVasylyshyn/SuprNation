package io.suprnation.assignment

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

import scala.collection.immutable.List

class TreeSpec extends AnyFlatSpec with Matchers {

  private val ints = List(
        List(1),
       List(1, 2),
      List(1, 2, 3)
  )

  private val expectedTree = Node(
    1,
    Node(
      1,
      Leaf(1),
      Leaf(2)
    ),
    Node(
      2,
      Leaf(2),
      Leaf(3)
    )
  )

  "Tree" should "be initialized" in {
    val actualTree = Tree(ints)
    actualTree shouldBe expectedTree
    actualTree.size shouldBe expectedTree.size
  }

}
