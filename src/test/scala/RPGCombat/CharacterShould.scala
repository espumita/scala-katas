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

    aCharacter.dealDamageTo(anotherCharacter, 100)

    anotherCharacter.health should be (900)
  }


}
