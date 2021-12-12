package one.xingyi.robert

sealed trait Planet {
  def modifiers: Planet => Double
  def modifier(otherPlanet: Planet, energy: Power): Power = energy.modify(modifiers(otherPlanet))
}


case object Mercury extends Planet {
  override def modifiers= Map(Mercury->1, Venus -> 2, Earth ->1, Mars ->0.5)
}
case object Venus extends Planet {
  override def modifiers = Map(Mercury->0.5, Venus -> 1, Earth ->2, Mars ->1)
}
case object Earth extends Planet {
  override def modifiers = Map(Mercury->1, Venus -> 0.5, Earth ->1, Mars ->2)
}
case object Mars extends Planet {
  override def modifiers = Map(Mercury->2, Venus -> 1, Earth ->0.5, Mars ->1)
}
