package RomanNumerals

case class RomanNumerals() {


  def get(number: Int): String = {
    if (number == 1) return "I"
    if (number == 4) return "IV"
    if (number == 5) return "V"
    if (number == 9) return "IX"
    if (number == 10) return "X"
    get(number - 1) + "I"
  }

}
