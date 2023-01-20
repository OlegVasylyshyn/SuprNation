package io.suprnation.assignment

sealed trait Tree:
  def isEmpty: Boolean = false

  def value: Int

case class Node(value: Int, left: Tree, right: Tree) extends Tree:
  override def toString: String =
    s"""Node
       |value: $value,
       |left: $left, right: $right
       |""".stripMargin

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
      if y >= ints.length || x >= ints(y).length then Empty
      else
        val value = ints(y)(x)
        val (leftSubNode, rightSubNode) = parallel(init(ints, (x, y + 1)), init(ints, (x + 1, y + 1)))
        if leftSubNode.isEmpty && rightSubNode.isEmpty then Leaf(value)
        else Node(value, leftSubNode, rightSubNode)

    init(ints, (0, 0))
