package RPGCombat

case object Faction {
  sealed trait Faction
  case object Faction1 extends Faction
  case object Faction2 extends Faction
  case object Faction3 extends Faction
}
