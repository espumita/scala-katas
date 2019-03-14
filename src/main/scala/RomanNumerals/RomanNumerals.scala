package RomanNumerals

case class RomanNumerals() {

  val romanNumbers = Map(
    (100, "C"),
    (90, "XC"),
    (50, "L"),
    (40, "XL"),
    (10, "X"),
    (9, "IX"),
    (5, "V"),
    (4, "IV"),
    (1, "I")
  )

  def get(number: Int): String = {
    if (romanNumbers contains number){
      return romanNumbers(number)
    }
    if (number > 100) return "C"+ get(number - 100)
    if (number > 90) return "XC" + get(number - 90)
    if (number > 50) return "L" + get(number - 50)
    if (number > 40) return "XL" + get(number - 40)
    if (number > 10) return "X" + get(number - 10)
    get(number - 1) + "I"
  }

}
