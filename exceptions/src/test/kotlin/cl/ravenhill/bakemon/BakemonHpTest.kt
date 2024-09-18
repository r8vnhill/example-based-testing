package cl.ravenhill.bakemon

import io.kotest.core.spec.style.FreeSpec
import io.kotest.matchers.shouldBe

class

BakemonHpTest : FreeSpec({
    "A Bakémon" - {
        "should have health points" {
            val bigachu = object : AbstractBakemon("Bigachu", 100) {}
            bigachu.healthPoints shouldBe 100
        }
    }
})
