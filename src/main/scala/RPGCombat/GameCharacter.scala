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

  def healthTo(focusCharacter: GameCharacter, healthPoints: Int) : Unit = {
    focusCharacter.receivesHealth(healthPoints)
  }

  def receivesHealth(healthPoints: Int): Unit = {
    health = health + healthPoints
  }




}
