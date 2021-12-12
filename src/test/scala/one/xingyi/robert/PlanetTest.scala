package one.xingyi.robert
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should

class PlanetTest extends AnyFlatSpec with should.Matchers {

  behavior of "Planet"

  it should "apply the modifier to a passed in energy" in {
    Mercury.modifier(Mercury, Power(5)) shouldBe Power(5)
    Mercury.modifier(Venus, Power(5)) shouldBe Power(10)
    Mercury.modifier(Earth, Power(5)) shouldBe Power(5)
    Mercury.modifier(Mars, Power(5)) shouldBe Power(2.5)

  }


}
