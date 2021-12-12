package one.xingyi.robert

case class Energy(amount: Double) {
  def takeDamage(power: Power): Energy = Energy(Math.max(0, amount-power.amount))

}
