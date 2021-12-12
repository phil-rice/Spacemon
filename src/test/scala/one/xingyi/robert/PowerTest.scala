package one.xingyi.robert
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers.convertToAnyShouldWrapper

class PowerTest extends AnyFlatSpec {


  behavior of "Power"

  it should "return a new power modified by the modifier" in {
    Power(5).modify(2) shouldBe Power(10)
    Power(5).modify(1) shouldBe Power(5)
    Power(5).modify(0) shouldBe Power(0)
    Power(5).modify(0.5) shouldBe Power(2.5)

  }
}
