import scala.annotation.tailrec
import scala.math.abs

def factorial(x: Int) = {
  @tailrec
  def loop(acc: Int, n: Int): Int =
    if (n == 0) acc
    else {
      loop(acc * n, n - 1)
    }

  loop(1, x)
}

factorial(5)

/**
 * Exercise 1
 */

def pascal(c: Int, r: Int): Int = {
  if (c == 0 || c == r) 1
  else if (c < 0) 0
  else pascal(c, r - 1) + pascal(c - 1, r - 1)
}

def main(args: Array[String]) {
  println("Pascal's Triangle")
  for (row <- 0 to 10) {
    for (col <- 0 to row)
      print(pascal(col, row) + " ")
    println()
  }
}

main(new Array[String](1))

/**
 * Exercise 2
 */
def balance(chars: List[Char]): Boolean = ???

/**
 * Exercise 3
 */
def countChange(money: Int, coins: List[Int]): Int = ???

def sqrt(x: Double) = {
  def isGoodEnough(guess: Double) = {
    val d = abs(guess * guess - x) / x
    d < 0.001
  }

  def improve(guess: Double) =
    (guess + x / guess) / 2

  def sqrtIter(guess: Double): Double = {
    if (isGoodEnough(guess)) guess else sqrtIter(improve(guess))
  }

  sqrtIter(guess = 1)
}

sqrt(1e50)