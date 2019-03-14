package RomanNumerals

case class RomanNumerals() {


  def get(number: Int): String = {
    if (number == 1) return "I"
    if (number == 4) return "IV"
    "I" + get(number - 1)
  }

}
