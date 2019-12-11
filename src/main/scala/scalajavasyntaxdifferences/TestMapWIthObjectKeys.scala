package scalajavasyntaxdifferences


object TestMapWIthObjectKeys {
  def main(args: Array[String]): Unit = {
    val map = Map(new KeyMock(1) -> 100, new KeyMock(2) -> 200)

    println(map(new KeyMock(1)))
  }
}

class KeyMock(val number: Int) {

  def canEqual(other: Any): Boolean = other.isInstanceOf[KeyMock]

  override def equals(other: Any): Boolean = other match {
    case that: KeyMock =>
      (that canEqual this) &&
        number == that.number
    case _ => false
  }

  override def hashCode(): Int = {
    val state = Seq(number)
    state.map(_.hashCode()).foldLeft(0)((a, b) => 31 * a + b)
  }
}