package RPGCombat

import org.scalatest.{Matchers, WordSpec}

class CharacterShould extends WordSpec with Matchers {


  "starts full health and first level"  in {
    val aCharacter = GameCharacter()

    aCharacter.health should be (1000)
    aCharacter.level should be (1)
    aCharacter.isAlive should be (true)
  }

  "can deal damage to other character" in {
    val aCharacter = GameCharacter()
    val anotherCharacter = GameCharacter()

    aCharacter.dealDamageTo(anotherCharacter, damage =  100)

    anotherCharacter.health should be (900)
  }

  "dies when health becomes 0 or less" in {
    val aCharacter = GameCharacter()
    val anotherCharacter = GameCharacter()

    aCharacter.dealDamageTo(anotherCharacter, damage =  2000)

    anotherCharacter.isAlive should be (false)
    anotherCharacter.health should be (0)
  }

  "can only health itself" in {
    val aCharacter = givenADamagedCharacter(damage = 100)

    aCharacter.healthItself(healthPoints =  100)

    aCharacter.health should be (1000)
  }

  "cannot be healed when it is dead" in {
    val aCharacter = givenADamagedCharacter(damage = 2000)

    aCharacter.healthItself(healthPoints =  100)

    aCharacter.health should be (0)
  }

  "cannot raise health above full health" in {
    val aCharacter = GameCharacter()

    aCharacter.healthItself(healthPoints =  100)

    aCharacter.health should be (1000)
  }

  "cannot deal damage to itself" in {
    val aCharacter = GameCharacter()

    aCharacter.dealDamageTo(aCharacter, 100)

    aCharacter.health should be (1000)
  }

  "deals 50% damage less when attacs a target that is 5 or more levels above" in {
    val aCharacter = GameCharacter(level = 1)
    val aNotherCharacter = GameCharacter(level = 6)

    aCharacter.dealDamageTo(aNotherCharacter, 100)

    aNotherCharacter.health should be (950)
  }




  def givenADamagedCharacter(damage: Int) : GameCharacter = {
    val character = GameCharacter()
    GameCharacter().dealDamageTo(character, damage)
    character
  }


}
