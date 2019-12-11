class TicTacToe(board: Array[Array[String]]) {

  def checkRowWinner: String = {
    var result = ""
    for (row <- board) {
      if (row.count(_ == "x") == 3) {
        result = "x"
      } else if (row.count(_ == "o") == 3) {
        result = "o"
      }

    }
    result
  }

  def checkColWinner: String = {
    val result = ""
    for (i <- board.indices) {
      var xcounter = 0
      var ocounter = 0
      for (j <- board.indices) {
        if (board(j)(i) == "x") {
          xcounter += 1
        } else if ((board(j)(i) == "o")) {
          ocounter += 1
        }
        if (xcounter == 3) {
          return "x"
        } else if (ocounter == 3) {
          return "o"
        }
      }
    }

    result
  }

  def checkDiagWinner(): String = {
    var result = ""
    if (board(0)(0) == "x" && board(1)(1) == "x" && board(2)(2) == "x") {
      result = "x"
    } else if (board(0)(0) == "y" && board(1)(1) == "y" && board(2)(2) == "y") {
      result = "y"
    }
    result
  }

  def checkWinner: Unit = {
    if (checkRowWinner == "x" || checkColWinner == "x" || checkDiagWinner == "x") {
      println("x won")
    } else if (checkRowWinner == "o" || checkColWinner == "o" || checkDiagWinner == "o") {
      println("o won")
    } else println("tie")
  }


}
