package io.suprnation.assignment

import scala.annotation.tailrec

sealed trait Tree:

  def insert(int: Int): Tree

  def isEmpty: Boolean = false

  def size: Int

  def minPath: Int

  def value: Int

var i = 0

case class Node(value: Int, left: Tree, right: Tree) extends Tree:
  def insert(x: Int): Tree =
    this match
      case Node(_, left, Empty) =>
        Node(value, left, Leaf(x))
      case Node(_, leftTree, rightTree) =>

        leftTree match
          case Node(value, _, Empty) =>
            Node(value, left.insert(x), right.insert(x))
          case Leaf(_) =>
            Node(value, left.insert(x), right)
          case _ =>
            Node(value, left, right.insert(x))

//        if right.size >= left.size then
//          Node(value, left.insert(x), right, size + 1)
//        else
//          Node(value, left, right.insert(x), size + 1)

  def size: Int = 1 + right.size + left.size

  def minPath: Int =
    value + left.minPath.min(right.minPath)


  override def toString: String =
    s"""Node
       |value: $value,
       |size: $size,
       |left: $left, right: $right
       |""".stripMargin

case class Leaf(value: Int) extends Tree:

  def size: Int = 1

  def insert(int: Int): Tree =
    Node(value, Leaf(int), Empty)

  def minPath: Int = value

  override def toString: String = s"Leaf($value)"


case object Empty extends Tree:

  def insert(int: Int): Tree =
    Leaf(int)

  override def isEmpty: Boolean = true

  def minPath: Int = 0

  def value: Int = throw new NotImplementedError("value on Empty tree")

  def size: Int = throw new NotImplementedError("size on Empty tree")

  override def toString: String = s"Empty"


object Tree:

  def apply(ints: List[List[Int]]): Tree =

    @tailrec
    def init(ints: List[List[Int]], acc: Tree): Tree =

      @tailrec
      def initFromList(xs: List[Int], acc: Tree): Tree =
        xs match
          case Nil => acc
          case head :: next =>
            initFromList(next, acc.insert(head))

      ints match
        case Nil => acc
        case head :: next =>
          init(next, initFromList(head, acc))

    init(ints, Empty)

