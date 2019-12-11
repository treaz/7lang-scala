package idioms

//https://stackoverflow.com/questions/12629721/coin-change-algorithm-in-scala-using-recursion
// I found it hard to design the algorithm myself, that's why it's in here
// Algo explanation: The idea here is to use up our coins and subtract it from the current amount of money.
// Eventually, the amount of money will be either 0, some negative number (meaning this combination of coins failed),
// or some positive number (meaning that we can still subtract more with the coins we currently have).
// countChange(money - coins.head, coins) will exhaust all combinations subtracting the first coin from the money,
// countChange(money, coins.tail) exhausts all combinations using all other coins only.
// They are added together, since + is synonymous with the logical OR operator.
class CoinChangeRecursion {

  def countChangeRec(money: Int, coins: List[Int]): Int =
    if (money == 0) 1
    else if (money < 0 || coins.isEmpty) 0
    else countChangeRec(money - coins.head, coins) + countChangeRec(money, coins.tail)


  def countChange(amount: Int, coins: List[Int]): Int = coins match {
    case _ if amount == 0 => 1
    case h :: t if amount > 0 => countChange(amount - h, h :: t) + countChange(amount, t)
    case _ => 0
  }
}
