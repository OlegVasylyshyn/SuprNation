package io.suprnation.assignment

import scala.io.Source

@main def run(): Unit =

  val filename = "data_big.txt"
  val source = Source.fromResource(filename)

  val ints = source.getLines().map { line =>
    line.split(" ").map(Integer.parseInt)
  }.toArray

  source.close()

  println(TrianglePath.min(ints))


