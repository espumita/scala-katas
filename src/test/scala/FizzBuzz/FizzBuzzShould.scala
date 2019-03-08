package FizzBuzz

import org.scalatest.{WordSpec, Matchers}

class FizzBuzzShould  extends WordSpec with Matchers {

  "return a number when a number is given" in {
    val fizzBuzz = FizzBuzz()

    val formattedNumber = fizzBuzz.format(1)

    formattedNumber should be ("1")
  }


}
