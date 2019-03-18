package RPGCombat

case class GameCharacter() {

  private val MAX_HEALTH = 1000
  var health: Int = MAX_HEALTH
  var level: Int = 1
  var isAlive: Boolean = true

  def dealDamageTo(focusCharacter: GameCharacter, damage: Int) : Unit = {
    focusCharacter.receivesDamage(damage)
  }

  def healthTo(focusCharacter: GameCharacter, healthPoints: Int) : Unit = {
    focusCharacter.receivesHealth(healthPoints)
  }

  private def receivesDamage(damage: Int) : Unit ={
    if (damage >= health) health = 0
    else health = health - damage
    if (health <= 0) isAlive = false
  }

  private def receivesHealth(healthPoints: Int): Unit = {
    if (!isAlive) return
    if (health == MAX_HEALTH) return
    if (health + healthPoints > MAX_HEALTH) health = MAX_HEALTH
    else health = health + healthPoints

  }




}
