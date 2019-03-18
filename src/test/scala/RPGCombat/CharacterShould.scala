package RPGCombat

import org.scalatest.{Matchers, WordSpec}

class CharacterShould extends WordSpec with Matchers {




  "a character starts full health and lvl 1"  in {
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

  "a character can health another character" in {
    val aCharacter = GameCharacter()
    val anotherCharacter = GameCharacter()
    anotherCharacter.receivesDamage(100)

    aCharacter.healthTo(anotherCharacter, healthPoints =  100)

    anotherCharacter.health should be (1000)
  }

  "dead characters cannot be healed" in {
    val aCharacter = GameCharacter()
    val anotherCharacter = GameCharacter()
    anotherCharacter.receivesDamage(2000)

    aCharacter.healthTo(anotherCharacter, healthPoints =  100)

    anotherCharacter.health should be (0)
  }


}
