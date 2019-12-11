package idioms

import java.util.NoSuchElementException

import scala.annotation.tailrec

class FunctionInFunction {

  def max(xs: List[Int]): Int = xs match {
    case Nil => throw new NoSuchElementException
    case _ =>
      @tailrec
      def max(xs: List[Int], theMax: Int): Int = xs match {
        case Nil => theMax
        case x :: tail => {
          val newMax = if (x > theMax) x else theMax
          max(tail, newMax)
        }
      }

      max(xs, xs.head)
  }
}
