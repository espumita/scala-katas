package RPGCombat

import RPGCombat.Faction.Faction


object CreateGameCharacter {
  def Melee() = GameCharacter(maxRange = 2)
  def Ranged() = GameCharacter(maxRange = 20)
}

case class GameCharacter(var level: Int = 1, var maxRange : Int = 0) {
  private val MAX_HEALTH = 1000

  var health: Int = MAX_HEALTH


  var isAlive: Boolean = true
  var factions: Set[Faction] = Set[Faction]()
  def dealDamageTo(focusCharacter: GameCharacter, damage: Int, distance: Int = 0) : Unit = {
    if (focusCharacter eq this) return
    if (factions.exists(focusCharacter.belongTo)) return
    if (distance > maxRange) return
    focusCharacter.receivesDamage(damage, level)
  }
  def healthItself(healthPoints: Int) : Unit = {
    receivesHealth(healthPoints)
  }

  def joinFaction(faction: Faction) : Unit = {
    factions = factions + faction
  }

  def leaveFaction(factionToLeave: Faction) : Unit = {
    factions = factions.filter(faction => !(faction eq factionToLeave))
  }

  private def belongTo(faction: Faction): Boolean = {
    factions contains(faction)
  }

  private def receivesDamage(damage: Int, attackerLevel: Int) : Unit ={
    val calculatedDamage = calculateDamage(damage, attackerLevel)
    resolve(calculatedDamage)
  }

  private def calculateDamage(damage: Int, attackerLevel: Int) : Int = {
    val levelDifference = attackerLevel - level
    if(levelDifference <= -5) return Math.round(damage * 0.5f)
    if(levelDifference >= 5 ) return Math.round(damage * 1.5f)
    damage
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
