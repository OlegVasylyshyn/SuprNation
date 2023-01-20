package io.suprnation.assignment

import scala.io.Source

@main def run(): Unit =

  val filename = "data_small.txt"
  val source = Source.fromResource(filename)

  val ints = source.getLines().map { line =>
    line.split(" ").map(Integer.parseInt).toList
  }.toList

  source.close()

  //  println("Was parsed next data: ")
  //  for (arr <- ints) {
  //    println()
  //    arr.foreach(print)
  //  }

  //  println(s"Total size: ${
  //    ints.map(_.length).sum
  //  }")

  val tree = Tree(ints)

  println(tree)

