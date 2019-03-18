package RPGCombat

case class GameCharacter() {

  var health: Int = 1000
  var level: Int = 1
  var isAlive: Boolean = true

  def dealDamageTo(focusCharacter: GameCharacter, damage: Int) : Unit = {
    focusCharacter.receivesDamage(damage)
  }

  def receivesDamage(damage: Int) : Unit ={
    if (damage >= health) health = 0
    else health = health - damage
    if (health <= 0) isAlive = false
  }

  def healthTo(focusCharacter: GameCharacter, healthPoints: Int) : Unit = {
    focusCharacter.receivesHealth(healthPoints)
  }

  def receivesHealth(healthPoints: Int): Unit = {
    if (!isAlive) return
    if (health == 1000) return
    if (health + healthPoints > 1000) health = 1000
    else health = health + healthPoints

  }




}
