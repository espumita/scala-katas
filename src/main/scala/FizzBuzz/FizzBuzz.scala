package FizzBuzz

case class FizzBuzz() {

  def format(number: Int): String = {
    if ( number % 3 == 0) "Fizz"
    else number.toString
  }

}
