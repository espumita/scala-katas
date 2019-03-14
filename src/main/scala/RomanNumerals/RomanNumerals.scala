package RomanNumerals

case class RomanNumerals() {


  def get(number: Int): String = {
    if (number > 50) return "L" + get(number - 50)
    if (number == 50) return "L"
    if (number > 40) return "XL" + get(number - 40)
    if (number == 40) return "XL"
    if (number > 10) return "X" + get(number - 10)
    if (number == 10) return "X"
    if (number == 9) return "IX"
    if (number == 5) return "V"
    if (number == 4) return "IV"
    if (number == 1) return "I"
    get(number - 1) + "I"
  }

}
