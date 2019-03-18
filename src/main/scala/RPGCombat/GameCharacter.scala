package RPGCombat

case class GameCharacter(var level: Int = 1) {

  private val MAX_HEALTH = 1000
  var health: Int = MAX_HEALTH
  var isAlive: Boolean = true

  def dealDamageTo(focusCharacter: GameCharacter, damage: Int) : Unit = {
    if (focusCharacter eq this) return
    focusCharacter.receivesDamage(damage, level)
  }

  def healthItself(healthPoints: Int) : Unit = {
    receivesHealth(healthPoints)
  }

  private def receivesDamage(damage: Int, attackerLevel: Int) : Unit ={
    val calculatedDamage = calculateDamage(damage, attackerLevel)
    resolve(calculatedDamage)
  }

  private def calculateDamage(damage: Int, attackerLevel: Int) : Int = {
    if(attackerLevel + 5 <= level) Math.round(damage * 0.5f)
    else damage
  }

  private def resolve(damage: Int) = {
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
