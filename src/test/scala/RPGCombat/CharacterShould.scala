package RPGCombat

import org.scalatest.{Matchers, WordSpec}

class CharacterShould extends WordSpec with Matchers {


  "a character starts full health and first level"  in {
    val aCharacter = GameCharacter()

    aCharacter.health should be (1000)
    aCharacter.level should be (1)
    aCharacter.isAlive should be (true)
  }

  "a character can deal damage to other character" in {
    val aCharacter = GameCharacter()
    val anotherCharacter = GameCharacter()

    aCharacter.dealDamageTo(anotherCharacter, damage =  100)

    anotherCharacter.health should be (900)
  }

  "a character dies when health becomes 0 or less" in {
    val aCharacter = GameCharacter()
    val anotherCharacter = GameCharacter()

    aCharacter.dealDamageTo(anotherCharacter, damage =  2000)

    anotherCharacter.isAlive should be (false)
    anotherCharacter.health should be (0)
  }

  "a character can only health itself" in {
    val aCharacter = givenADamagedCharacter(damage = 100)

    aCharacter.healthItself(healthPoints =  100)

    aCharacter.health should be (1000)
  }

  "dead characters cannot be healed" in {
    val aCharacter = givenADamagedCharacter(damage = 2000)

    aCharacter.healthItself(healthPoints =  100)

    aCharacter.health should be (0)
  }

  "heal cannot raise health above character full health" in {
    val aCharacter = GameCharacter()

    aCharacter.healthItself(healthPoints =  100)

    aCharacter.health should be (1000)
  }

  "a character cannot deal damage to itself" in {
    val aCharacter = GameCharacter()

    aCharacter.dealDamageTo(aCharacter, 100)

    aCharacter.health should be (1000)
  }

  def givenADamagedCharacter(damage: Int) : GameCharacter = {
    val character = GameCharacter()
    GameCharacter().dealDamageTo(character, damage)
    character
  }


}
