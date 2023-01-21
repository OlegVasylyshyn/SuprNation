package io.suprnation.assignment

import scala.io.Source

@main def run(fileName: String): Unit =

  println(s"FILE - $fileName")

  val source = Source.fromResource(fileName)

  val ints = source.getLines().map { line =>
    line.split(" ").map(Integer.parseInt)
  }.toArray

  source.close()

  println(s"MIN PATH - ${TrianglePath.min(ints)}")
  println(s"MAX PATH - ${TrianglePath.max(ints)}")



