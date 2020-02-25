
object ws {

  trait GeneratorSimple[T] {
    def generate: T
  }


  trait Generator[T] {
    self => // alias for "this"

    def generate: T

    def map[S](f: T => S): Generator[S] = new Generator[S] {
      def generate: S = f(self.generate)
    }

    def flatMap[S](f: T => Generator[S]): Generator[S] = new Generator[S] {
      def generate = f(self.generate).generate
    }

    List()
  }

  val integers = new Generator[Int] {
    val rand = new java.util.Random

    def generate = rand.nextInt()
  }

  //I want this:
  val booleans = for (x <- integers) yield x > 0

  //
  def pairs[T, U](t: Generator[T], u: Generator[U]) = for {
    x <- t
    y <- u
  } yield (x, y)

  booleans.generate

  def choose(lo: Int, hi: Int): Generator[Int] =
    for (x <- integers) yield lo + x % (hi - lo)

  choose(66, 99).generate

  def oneOf[T](xs: T*): Generator[T] =
    for (index <- choose(0, xs.length)) yield xs(index)


  oneOf(1, 2, 3, 7, 9).generate

  def single[T](x: T): Generator[T] = new Generator[T] {
    override def generate = x
  }


  def lists: Generator[List[Int]] = for {
    isEmpty <- booleans
    list <- if (isEmpty) emptyLists else nonEmptyLists
  } yield list

  def emptyLists = single(Nil)

  def nonEmptyLists: Generator[List[Int]] = for {
    head <- integers
    tail <- lists
  } yield head :: tail

  trait Tree

  case class Inner(left: Tree, right: Tree) extends Tree

  case class Leaf(x: Int) extends Tree

  def leafs: ws.Generator[Leaf] = for {
    x <- ws.integers
  } yield Leaf(x)

  def inners: ws.Generator[Inner] = for {
    l <- trees
    r <- trees
  } yield Inner(l, r)

  def trees: ws.Generator[Tree] = for {
    isLeaf <- ws.booleans
    tree <- if (isLeaf) leafs else inners
  } yield tree

}

ws.trees.generate


