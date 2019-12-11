object Main {

  def main(args: Array[String]): Unit = {
    val tic = new TicTacToe(Array(
      Array("o", "o", "x"),
      Array("o", "x", "x"),
      Array("o", "x", "o")))
    tic.checkWinner
  }
}
