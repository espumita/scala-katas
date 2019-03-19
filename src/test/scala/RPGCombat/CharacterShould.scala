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

  "deals 50% damage less when attacks a target that is 5 or more levels above" in {
    val aCharacter = GameCharacter(level = 1)
    val anotherCharacter = GameCharacter(level = 6)

    aCharacter.dealDamageTo(anotherCharacter, 100)

    anotherCharacter.health should be (950)
  }

  "deals 50% damage more when attacks a target that is 5 or more levels below" in {
    val aCharacter = GameCharacter(level = 6)
    val anotherCharacter = GameCharacter(level = 1)

    aCharacter.dealDamageTo(anotherCharacter, 100)

    anotherCharacter.health should be (850)
  }

  "have an attack max range" in {
    val aCharacter = GameCharacter(maxRange = 8)
    val anotherCharacter = GameCharacter()

    aCharacter.dealDamageTo(anotherCharacter, damage =  100, distance =  10)

    anotherCharacter.health should be (1000)
  }

  "melee fighters have a range of 2 meters" in {
    val aCharacter = CreateGameCharacter.Melee()
    val anotherCharacter = GameCharacter()

    aCharacter.dealDamageTo(anotherCharacter, damage =  100, distance =  12)
    aCharacter.dealDamageTo(anotherCharacter, damage =  50, distance =  1)

    anotherCharacter.health should be (950)
  }

  "ranged fighters have a range of 20 meters" in {
    val aCharacter = CreateGameCharacter.Ranged()
    val anotherCharacter = GameCharacter()

    aCharacter.dealDamageTo(anotherCharacter, damage =  100, distance =  21)
    aCharacter.dealDamageTo(anotherCharacter, damage =  50, distance =  6)

    anotherCharacter.health should be (950)
  }


  "do not belong to any faction when there is newly created" in {
    val aCharacter = GameCharacter()

    aCharacter.factions.size should be (0)
  }


  "may join or leave one or more factions" in {
    val aCharacter = GameCharacter()

    aCharacter.joinFaction(Faction.Faction1)
    aCharacter.leaveFaction(Faction.Faction1)
    aCharacter.joinFaction(Faction.Faction2)

    aCharacter.factions.size should be (1)
  }

  "allies cannot deal damage to one another" in {
    val aCharacter = GameCharacter()
    val anotherCharacter = GameCharacter()
    aCharacter.joinFaction(Faction.Faction1)
    anotherCharacter.joinFaction(Faction.Faction1)

    aCharacter.dealDamageTo(anotherCharacter, damage = 50)

    anotherCharacter.health should be (1000)
  }

  "allies can heal one another." in {
    val aCharacter = GameCharacter()
    val anotherCharacter = givenADamagedCharacter(damage = 200)
    aCharacter.joinFaction(Faction.Faction1)
    anotherCharacter.joinFaction(Faction.Faction1)

    aCharacter.healthTo(anotherCharacter, healthPoints = 200)

    anotherCharacter.health should be (1000)
  }



  def givenADamagedCharacter(damage: Int) : GameCharacter = {
    val character = GameCharacter()
    GameCharacter().dealDamageTo(character, damage)
    character
  }


}
