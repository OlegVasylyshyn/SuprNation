package io.suprnation.assignment

import scala.annotation.tailrec

sealed trait Tree:

  def insert(int: Int): Tree

  def isEmpty: Boolean = false

  def value: Int

case class Node(value: Int, left: Tree, right: Tree, size: Int) extends Tree:
  def insert(x: Int): Tree =
    this match
      case Node(_, left, Empty, _) =>
        Node(value, left, Leaf(x), size)
      case Node(_, _, _, _) =>
        Node(value, left.insert(x), right, size + 1)


  override def toString: String =
    s"""Node
       |value: $value,
       |size: $size,
       |left: $left, right: $right
       |""".stripMargin

case class Leaf(value: Int) extends Tree:

  def insert(int: Int): Tree =
    Node(value, Leaf(int), Empty, size = 2)

  override def toString: String = s"Leaf($value)"


case object Empty extends Tree:

  def insert(int: Int): Tree =
    Leaf(int)

  override def isEmpty: Boolean = true

  def value: Int = throw new NotImplementedError("value on Empty tree")

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
//            Thread.sleep(1000)
            initFromList(next, acc.insert(head))

      ints match
        case Nil => acc
        case head :: next =>
          init(next, initFromList(head, acc))

    init(ints, Empty)

