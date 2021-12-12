package one.xingyi.robert

sealed trait Team {

}

object Team {
  def friendlyCompetitionToTheFluffyNonDeath(team1: List[SpaceMon], team2: List[SpaceMon]):Team =
    (team1, team2) match {
      case (head :: tail, Nil) => Team1
      case (Nil, head :: tail) => Team2
      case (head1:: tail1, head2::tail2)  =>
         SpaceMon.fightToTheFluffyNonDeath(head1, head2) match {
           case (Team1, newSm1) => friendlyCompetitionToTheFluffyNonDeath(newSm1::tail1, tail2)
           case (Team2, newSm2) =>friendlyCompetitionToTheFluffyNonDeath(tail1, newSm2::tail2)
         }
    }

}

case object Team1 extends Team
case object Team2 extends Team
