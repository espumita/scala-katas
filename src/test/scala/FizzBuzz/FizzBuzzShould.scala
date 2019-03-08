package FizzBuzz

import org.scalatest.{BeforeAndAfterEach, Matchers, WordSpec}

class FizzBuzzShould  extends WordSpec with Matchers with  BeforeAndAfterEach {


  var fizzBuzz: FizzBuzz = _

  override protected def beforeEach() = {
    fizzBuzz = FizzBuzz()
  }


  "return a number when a number is given" in {

    val formattedNumber = fizzBuzz.format(1)

    formattedNumber should be ("1")
  }

  "return Fizz when a number is multiple of three" in {

    val formattedNumber = fizzBuzz.format(3)

    formattedNumber should be ("Fizz")
  }

  "return Buzz when a number is multiple of five" in {

    val formattedNumber = fizzBuzz.format(5)

    formattedNumber should be ("Buzz")
  }

}
