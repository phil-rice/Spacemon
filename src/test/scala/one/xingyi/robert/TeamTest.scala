package one.xingyi.robert
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers.convertToAnyShouldWrapper

class TeamTest extends AnyFlatSpec with SpaceMonFixture {

  behavior of "Team"

  val roster1: List[SpaceMon] = List((Earth, 100, 10), (Earth, 100, 10))
  val roster2: List[SpaceMon] = List((Mercury, 80, 10), (Venus, 80, 10))
  it should "have a friendlyCompetitionToTheFluffyNonDeath method which works out which team wins" in {
    Team.friendlyCompetitionToTheFluffyNonDeath(roster1, roster2) shouldBe Team2
    Team.friendlyCompetitionToTheFluffyNonDeath(roster2, roster1) shouldBe Team1

  }

}
