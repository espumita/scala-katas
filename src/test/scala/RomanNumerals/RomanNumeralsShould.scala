package RomanNumerals

import org.scalatest.{BeforeAndAfterEach, Matchers, WordSpec}

class RomanNumeralsShould extends WordSpec with Matchers with  BeforeAndAfterEach {


  "return I when number is 1" in {
    val romanNumerals = RomanNumerals()

    val formattedNumber = romanNumerals.format(1)

    formattedNumber should be ("I")
  }

}
