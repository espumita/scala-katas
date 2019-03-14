package RomanNumerals

import org.scalatest.{BeforeAndAfterEach, Matchers, WordSpec}

class RomanNumeralsShould extends WordSpec with Matchers with  BeforeAndAfterEach {

  var romanNumerals: RomanNumerals = _

  override protected def beforeEach() = {
    romanNumerals = RomanNumerals()
  }


  "return I when number is 1,2 or 3" in {

    romanNumerals.get(1) should be ("I")
    romanNumerals.get(2) should be ("II")
    romanNumerals.get(3) should be ("III")
  }

  "return IV when number 4" in {

    romanNumerals.get(4) should be ("IV")
  }




}
