import scala.math.abs

object Week2 {

  def sum(f: Int => Int, a: Int, b: Int) = {
    def loop(a: Int, acc: Int): Int =
      if (a > b) acc
      else loop(a + 1, acc + f(a))

    loop(a, 0)
  }

  def sum2(f: Int => Int)(a: Int, b: Int): Int =
    if (a > b) 0 else f(a) + sum2(f)(a + 1, b)


  def product(f: Int => Int)(a: Int, b: Int): Int = {
    if (a > b) 1 else f(a) * product(f)(a + 1, b)
  }

  def mapReduce(f: Int => Int, combine: (Int, Int) => Int, unitValue: Int)(a: Int, b: Int): Int = {
    if (a > b)
      unitValue
    else
      combine(f(a), mapReduce(f, combine, unitValue)(a + 1, b))
  }

  def factorial(n: Int): Int = product(x => x)(1, n)

  def main(args: Array[String]): Unit = {
    //    println(sum(x => x, 1, 10))
    //    println(product(x => x)(1, 5))
    //    println(product(x => x)(1, 5))
    //    println(mapReduce(x => x, (a, b) => a * b, 1)(1, 5))
    //
    //    println(factorial(5)) //120
    println(sqrt(2))
    println(sqrtAvgD(2))
  }

  val tolerance = 0.0001

  def isCloseEnough(x: Double, y: Double) =
    abs((x - y) / x) / x < tolerance

  def fixedPoint(f: Double => Double)(firstGuess: Double) = {
    def iterate(guess: Double): Double = {
      println("guess=" + guess)
      val next = f(guess)
      if (isCloseEnough(guess, next)) next
      else iterate(next)
    }

    iterate(firstGuess)
  }

  def sqrt(x: Double) = fixedPoint(y => (y + x / y) / 2)(1.0)

  def averageDamp(f: Double => Double)(x: Double) = (x + f(x)) / 2

  def sqrtAvgD(x: Double) = fixedPoint(averageDamp(y => x / y))(2.0)
}
