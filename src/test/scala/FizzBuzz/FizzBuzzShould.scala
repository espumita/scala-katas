package FizzBuzz

import org.scalatest.{WordSpec, Matchers}

class FizzBuzzShould  extends WordSpec with Matchers {

  "return a number when a number is given" in {
    val fizzBuzz = FizzBuzz()

    val formattedNumber = fizzBuzz.format(1)

    formattedNumber should be ("1")
  }

  "return Fizz when a number is multiple of three" in {
    val fizzBuzz = FizzBuzz()

    val formattedNumber = fizzBuzz.format(3)

    formattedNumber should be ("Fizz")
  }

  "return Buzz when a number is multiple of five" in {
    val fizzBuzz = FizzBuzz()

    val formattedNumber = fizzBuzz.format(5)

    formattedNumber should be ("Buzz")
  }

}
