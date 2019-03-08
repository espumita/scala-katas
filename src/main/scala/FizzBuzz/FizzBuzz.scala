package FizzBuzz

case class FizzBuzz() {

  def format(number: Int): String = {
    if (isMultipleOfThree(number)) "Fizz"
    else number.toString
  }

  private def isMultipleOfThree(number: Int) = {
    number % 3 == 0
  }
}
