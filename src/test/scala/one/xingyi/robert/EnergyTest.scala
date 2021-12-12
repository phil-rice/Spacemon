package one.xingyi.robert
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers.convertToAnyShouldWrapper

class EnergyTest extends AnyFlatSpec {
  behavior of "Energy"

  it should "be able to take damage and return a new energy with the power subtracted from it" in {
    Energy(10).takeDamage(Power(3)) shouldBe Energy(7)
    Energy(10).takeDamage(Power(10)) shouldBe Energy(0)
    Energy(10).takeDamage(Power(20)) shouldBe Energy(0)
    Energy(10).takeDamage(Power(11)) shouldBe Energy(0)
  }

}
