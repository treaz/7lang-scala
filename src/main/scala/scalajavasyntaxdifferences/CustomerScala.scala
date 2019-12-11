package scalajavasyntaxdifferences

class CustomerScala(val name: String, val address: String) {
  val fullname = String.format("%s %s", name, address)
  private var id = ""
}

object CustomerScala {
  def main(args: Array[String]): Unit = {
    val eric = new CustomerScala("Eric", "n/a")
    eric.id = "asdfasdf"
  }
}
