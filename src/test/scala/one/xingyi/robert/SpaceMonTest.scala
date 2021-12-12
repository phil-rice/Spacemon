package one.xingyi.robert
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers.convertToAnyShouldWrapper

trait SpaceMonFixture {
  implicit def tupleToSpaceMon(tuple: (Planet, Int, Int)): SpaceMon = SpaceMon(tuple._1, Energy(tuple._2), Power(tuple._3))


}
class SpaceMonTest extends AnyFlatSpec with SpaceMonFixture {
  def fight(sp1: SpaceMon, sp2: SpaceMon) = SpaceMon.fightFightFight(sp1, sp2)

  behavior of "SpaceMon"
  it should "have an attacked by method that returns a copy of 'me' with the damage taken" in {
    (Mercury, 12, 10).attackedBy(Mars, 7, 4) shouldBe SpaceMon(Mercury, Energy(4), Power(10))
  }

  it should "resolve a single fight returning two new space mon, The team1 foes first - team 1 defeats team2, so doesn't take damage" in {
    fight((Mercury, 10, 5), (Venus, 5, 6)) shouldBe
      (SpaceMon(Mercury, Energy(10.0), Power(5.0)), SpaceMon(Venus, Energy(0.0), Power(6.0)))
  }
  it should "resolve a single fight returning two new space mon, The team1 foes first - team 1 weakens team2, so does take damage" in {
    fight((Mercury, 100, 5), (Mars, 50, 6)) shouldBe
      (SpaceMon(Mercury, Energy(88), Power(5.0)), SpaceMon(Mars, Energy(47.5), Power(6.0)))
  }
  it should "resolve a single fight returning two new space mon, The team1 foes first - team 1 weakens team2, then dies" in {
    fight((Mercury, 10, 5), (Mars, 50, 6)) shouldBe
      (SpaceMon(Mercury, Energy(0), Power(5.0)), SpaceMon(Mars, Energy(47.5), Power(6.0)))
  }

  it should "have fightToTheFluffyNonDeath" in {
    SpaceMon.fightToTheFluffyNonDeath((Earth, 100, 10), (Mercury, 80, 10)) shouldBe
      (Team1, SpaceMon(Earth, Energy(30), Power(10)))
    SpaceMon.fightToTheFluffyNonDeath((Mercury, 80, 10), (Earth, 100, 10)) shouldBe
      (Team2, SpaceMon(Earth, Energy(20), Power(10)))
  }

  it should "have a fluffily is defeated method " in {
    (Mercury, 80, 10).isFluffilyDefeated shouldBe false
    (Mercury, 0, 10).isFluffilyDefeated shouldBe true
  }

}
