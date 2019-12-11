package idioms

//https://alvinalexander.com/scala/fp-book/recursion-how-write-sum-function-functional
class ListRecursionWithMatch {

  def sum(list: List[Int]): Int = list match {
    case Nil => 0 //If the List is empty, return 0.
    case head :: tail => head + sum(tail) // using :: to decompose into a list with head and tail https://www.scala-lang.org/api/2.5.1/scala/$colon$colon.html
  }
}
