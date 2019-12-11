package idioms

//https://stackoverflow.com/questions/13337338/call-by-name-vs-call-by-value-in-scala-clarification-needed
class CallByNameVSCallByValue {
  def something() = {
    println("calling something")
    1 // return value
  }

  def callByValue(x: Int) = {
    println("x1=" + x)
    println("x2=" + x)
  }

  def callByName(x: => Int) = {
    println("x1=" + x)
    println("x2=" + x)
  }

}


object CallByNameVSCallByValue {

  def main(args: Array[String]): Unit = {
    val test = new CallByNameVSCallByValue
    println("callByValue")
    test.callByValue(test.something())
    println("-------------------")
    println("callByName")
    test.callByName(test.something())
  }
}