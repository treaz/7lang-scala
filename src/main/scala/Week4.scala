object Week4 {
  def main(args: Array[String]): Unit = {
    val list = List(1, 2, 3, 4)
    list.sorted

  }

  def insert(x: Int, xs: List[Int]): List[Int] = xs match {
    case List() => List(x)
    case y :: ys => if (x <= y) x :: xs else y :: insert(x, ys)
  }

  //  performance: n*n
  def insertSort(xs: List[Int]): List[Int] = xs match {
    case List() => List()
    case y :: ys => insert(y, insertSort(ys))
  }


  def arrayIsInvariant = {
    //    this will not compile
    //    val a:Array[NonEmpty] = Array(new NonEmpty(1, Empty, Empty))
    //    val b: Array[IntSet] = a
    //    b(0) = Empty
    //    val s: NonEmpty = a(0)
  }

  class IntSet

  class NonEmpty(elem: Int, args: IntSet*) extends IntSet

  object Empty extends IntSet

}


