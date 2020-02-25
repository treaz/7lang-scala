object Week3 {
  def main(args: Array[String]): Unit = {
    val b = new B
    println(b.foo)
    println(b.bar)

    val list = List(1, 2, 3, 6, 7, 8, 9)
    println(nth(5, list))
  }

  def singleton[T](elem: T) = new Cons[T](elem, null)

  def nth[A](n: Int, xs: List[A]): A = {
    //    if (n < 0 || n >= xs.size) throw new IndexOutOfBoundsException
    //    val current = 0

    //    def getNth[A](curr: Int, list: List[A]): A = if (curr == n) list.head else getNth(curr + 1, list.tail)
    //    getNth(current, xs)
    if (xs.isEmpty) throw new IndexOutOfBoundsException
    else if (n == 0) xs.head
    else nth(n - 1, xs.tail)
  }

  abstract class A {
    def foo = 1

    def bar: Int
  }

  class B extends A {
    override def foo = 11

    def bar: Int = 42
  }

  class Cons[T](val head: T, tail: Null)

}


