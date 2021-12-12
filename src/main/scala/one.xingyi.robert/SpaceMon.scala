package one.xingyi.robert

case class SpaceMon(planet: Planet, energy: Energy, power: Power) {
  def attackedBy(sp: SpaceMon) = copy(energy = energy.takeDamage(sp.planet.modifier(planet, sp.power)))
  def isFluffilyDefeated: Boolean = energy.amount == 0
}

object SpaceMon {
  def fightFightFight(spaceMon1: SpaceMon, spaceMon2: SpaceMon): (SpaceMon, SpaceMon) =
    spaceMon2.attackedBy(spaceMon1) match {
      case newSp2 if newSp2.isFluffilyDefeated => (spaceMon1, newSp2)
      case newSp2 => (spaceMon1.attackedBy(spaceMon2), newSp2)
    }

  def fightToTheFluffyNonDeath(spaceMon1: SpaceMon, spaceMon2: SpaceMon): (Team, SpaceMon) =
    fightFightFight(spaceMon1, spaceMon2) match {
      case (newSm1, newSm2) if newSm1.isFluffilyDefeated => (Team2, newSm2)
      case (newSm1, newSm2) if newSm2.isFluffilyDefeated => (Team1, newSm1)
      case (newSm1, newSm2) => fightToTheFluffyNonDeath(newSm1, newSm2)
    }

}