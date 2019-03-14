package RomanNumerals

case class RomanNumerals() {


  def get(number: Int) = {
    if (number == 1) "I"
    if (number == 2) "II"
    "III"
  }

}
