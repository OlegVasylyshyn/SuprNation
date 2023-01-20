package io.suprnation.assignment

import scala.io.Source

@main def run(): Unit =

  val filename = "data_small.txt"
  val source = Source.fromResource(filename)

  val ints = source.getLines().map { line =>
    line.split(" ").map(Integer.parseInt).toList
  }.toList

  source.close()

  val tree = Tree(ints)

  println(tree)

  println()

  println(tree.minPath)

