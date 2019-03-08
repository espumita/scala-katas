package FizzBuzz

case class FizzBuzz() {


  def format(number: Int): String = {
    if (isMultipleOfThreeAndFive(number)) return "FizzBuzz"
    if (isMultipleOfThree(number)) return "Fizz"
    if (isMultipleOfFive(number)) "Buzz"
    else number.toString
  }

  private def isMultipleOfThreeAndFive(number: Int) = {
    isMultipleOfThree(number) && isMultipleOfFive(number)
  }

  private def isMultipleOfThree(number: Int) = {
    number % 3 == 0
  }

  private def isMultipleOfFive(number: Int) = {
    number % 5 == 0
  }

}
