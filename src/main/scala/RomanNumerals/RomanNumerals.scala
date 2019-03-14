package RomanNumerals

case class RomanNumerals() {


  def get(number: Int): String = {
    if (number == 1) return "I"
    if (number == 2) return "II"
    "III"
  }

}
