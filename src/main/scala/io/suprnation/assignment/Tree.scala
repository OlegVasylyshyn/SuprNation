package io.suprnation.assignment

sealed trait Tree:
  def isEmpty: Boolean = false

  def value: Int

case class Node(left: Tree, right: Tree, value: Int) extends Tree:
  override def toString: String = s"Node(left: $left, right: $right, value: $value)"

case class Leaf(value: Int) extends Tree:
  override def toString: String = s"Leaf($value)"


case object Empty extends Tree:
  override def isEmpty: Boolean = true

  def value: Int = throw new NotImplementedError("value on Empty tree")

  override def toString: String = s"Empty"


object Tree:

  def apply(ints: Array[Array[Int]]): Tree =
    def init(ints: Array[Array[Int]], startPoint: (Int, Int)): Tree =
      val (x, y) = startPoint
      if x >= ints.length || y >= ints(x).length then Empty
      else
        val value = ints(x)(y)
        val leftSubNode = init(ints, (x, y + 1))
        val rightSubNode = init(ints, (x + 1, y + 1))
        if leftSubNode.isEmpty && rightSubNode.isEmpty then Leaf(value)
        else Node(leftSubNode, rightSubNode, value)

    init(ints, (0, 0))
