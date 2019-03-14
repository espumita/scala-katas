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

  def get(number: Int): String = number match {
    case _ if romanNumbers contains number => romanNumbers(number)
    case _ if number > 100 => add(100, number)
    case _ if number > 90 => add(90, number)
    case _ if number > 50 => add(50, number)
    case _ if number > 40 => add(40, number)
    case _ if number > 10 => add(10, number)
    case _ => get(number - 1) + romanNumbers(1)
  }

  private def add(value: Int, number: Int) = {
    romanNumbers(value) + get(number - value)
  }

}
