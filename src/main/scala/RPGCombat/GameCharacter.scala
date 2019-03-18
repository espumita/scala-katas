package RPGCombat

case class GameCharacter() {
  var health: Int = 1000


  var level: Int = 1
  var isAlive: Boolean = true

  def dealDamageTo(focusCharacter: GameCharacter, damage: Int) : Unit = {
    focusCharacter.receivesDamage(damage)
  }

  def receivesDamage(damage: Int) : Unit ={
    health = health - damage
    if (health < 0) isAlive = false
  }




}
