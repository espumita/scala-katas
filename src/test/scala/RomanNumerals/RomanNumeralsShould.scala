package RomanNumerals

import org.scalatest.{BeforeAndAfterEach, Matchers, WordSpec}

class RomanNumeralsShould extends WordSpec with Matchers with  BeforeAndAfterEach {

  var romanNumerals: RomanNumerals = _

  override protected def beforeEach() = {
    romanNumerals = RomanNumerals()
  }


  "return I when number is 1" in {

    val formattedNumber = romanNumerals.get(1)

    formattedNumber should be ("I")
  }

  "return II when number is 2" in {

    val formattedNumber = romanNumerals.get(2)

    formattedNumber should be ("II")
  }

  "return III when number is 2" in {

    val formattedNumber = romanNumerals.get(3)

    formattedNumber should be ("III")
  }


}
