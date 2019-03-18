package RPGCombat

case class GameCharacter() {

  var health: Int = 1000
  var level: Int = 1
  var isAlive: Boolean = true

  def dealDamageTo(focusCharacter: GameCharacter, damage: Int) : Unit = {
    focusCharacter.health = focusCharacter.health - damage
  }




}
