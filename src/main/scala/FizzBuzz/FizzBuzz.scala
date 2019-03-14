package FizzBuzz

case class FizzBuzz() {




  def format(number: Int): String = (isMultipleOfThree(number), isMultipleOfFive(number)) match {
    case (true, true) => "FizzBuzz"
    case (true, _) => "Fizz"
    case (_, true) => "Buzz"
    case (_, _) => number.toString
  }

  private def isMultipleOfThree(number: Int) = {
    number % 3 == 0
  }

  private def isMultipleOfFive(number: Int) = {
    number % 5 == 0
  }

}
