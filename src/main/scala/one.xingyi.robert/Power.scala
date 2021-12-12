package one.xingyi.robert

case class Power(amount: Double) extends AnyVal{
  def modify(modifier: Double): Power = Power(amount*modifier)
}
