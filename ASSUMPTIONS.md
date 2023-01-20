1. Implemented tree structure
2. Implemented method for initialization
3. Ran into issue with memory. My recursion is not optimized for huge trees.
```scala
  def apply(ints: Array[Array[Int]]): Tree =
    def init(ints: Array[Array[Int]], startPoint: (Int, Int)): Tree =
      val (x, y) = startPoint
      if y >= ints.length || x >= ints(y).length then Empty
      else
        val value = ints(y)(x)
        val leftSubNode = init(ints, (x, y + 1)) // FIXME: Rec 
        val rightSubNode = init(ints, (x + 1, y + 1)) // FIXME: Rec
        if leftSubNode.isEmpty && rightSubNode.isEmpty then Leaf(value)
        else Node(value, leftSubNode, rightSubNode)

    init(ints, (0, 0))
```
4. Doubting to implement loop or tail rec instead.
5. Another fascinating side solution is to make my tree lazy. 
  Example: 
```scala
case class Node(value: Int, left: => Tree, right: => Tree) extends Tree
```
parameters _by-name_ will make it faster to init. But not sure if it will be suitable for further computations.
6. Increased memory and changed GC and used parallel computation. It didn't help. Need to change algorithm. 
7. Done with initialization of the Tree structure from file. Next step is to calculate paths. 
8. Found bug in Tree initialization. 
9. Fixed bug. Added unit test.
