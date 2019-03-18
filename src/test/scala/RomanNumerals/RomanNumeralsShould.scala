package RomanNumerals

import org.scalatest.{Matchers, WordSpec}

class RomanNumeralsShould extends WordSpec with Matchers {


  "get roman numeral when number is given" in {
    val romanNumerals = RomanNumerals()
    romanNumerals.format(1) should be ("I")
    romanNumerals.format(2) should be ("II")
    romanNumerals.format(3) should be ("III")
    romanNumerals.format(4) should be ("IV")
    romanNumerals.format(5) should be ("V")
    romanNumerals.format(6) should be ("VI")
    romanNumerals.format(7) should be ("VII")
    romanNumerals.format(8) should be ("VIII")
    romanNumerals.format(9) should be ("IX")
    romanNumerals.format(10) should be ("X")
    romanNumerals.format(11) should be ("XI")
    romanNumerals.format(13) should be ("XIII")
    romanNumerals.format(14) should be ("XIV")
    romanNumerals.format(18) should be ("XVIII")
    romanNumerals.format(19) should be ("XIX")
    romanNumerals.format(20) should be ("XX")
    romanNumerals.format(39) should be ("XXXIX")
    romanNumerals.format(40) should be ("XL")
    romanNumerals.format(41) should be ("XLI")
    romanNumerals.format(49) should be ("XLIX")
    romanNumerals.format(50) should be ("L")
    romanNumerals.format(51) should be ("LI")
    romanNumerals.format(89) should be ("LXXXIX")
    romanNumerals.format(90) should be ("XC")
    romanNumerals.format(99) should be ("XCIX")
    romanNumerals.format(100) should be ("C")
    romanNumerals.format(399) should be ("CCCXCIX")
  }


}
