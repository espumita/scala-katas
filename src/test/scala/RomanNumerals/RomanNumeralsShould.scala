package RomanNumerals

import org.scalatest.{BeforeAndAfterEach, Matchers, WordSpec}

class RomanNumeralsShould extends WordSpec with Matchers with  BeforeAndAfterEach {

  var romanNumerals: RomanNumerals = _

  override protected def beforeEach() = {
    romanNumerals = RomanNumerals()
  }

  "get roman numeral when number is given" in {
    romanNumerals.get(1) should be ("I")
    romanNumerals.get(2) should be ("II")
    romanNumerals.get(3) should be ("III")
    romanNumerals.get(4) should be ("IV")
    romanNumerals.get(5) should be ("V")
    romanNumerals.get(6) should be ("VI")
    romanNumerals.get(7) should be ("VII")
    romanNumerals.get(8) should be ("VIII")
    romanNumerals.get(9) should be ("IX")
    romanNumerals.get(10) should be ("X")
    romanNumerals.get(11) should be ("XI")
    romanNumerals.get(13) should be ("XIII")
    romanNumerals.get(14) should be ("XIV")
    romanNumerals.get(18) should be ("XVIII")
    romanNumerals.get(19) should be ("XIX")
    romanNumerals.get(20) should be ("XX")
    romanNumerals.get(39) should be ("XXXIX")
    romanNumerals.get(40) should be ("XL")
    romanNumerals.get(41) should be ("XLI")
    romanNumerals.get(49) should be ("XLIX")
    romanNumerals.get(50) should be ("L")
    romanNumerals.get(51) should be ("LI")
    romanNumerals.get(89) should be ("LXXXIX")
    romanNumerals.get(90) should be ("XC")
    romanNumerals.get(99) should be ("XCIX")
    romanNumerals.get(100) should be ("C")
    romanNumerals.get(399) should be ("CCCXCIX")
  }


}
