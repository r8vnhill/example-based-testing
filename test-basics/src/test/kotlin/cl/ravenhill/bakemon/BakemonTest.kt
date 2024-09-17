package cl.ravenhill.bakemon

import io.kotest.core.spec.style.FreeSpec
import io.kotest.matchers.shouldBe

private const val BAKEMON_NAME = "Bigachu"
private const val BAKEMON_HEALTH = 100

class BakemonTest : FreeSpec({
    lateinit var bigachu: Bakemon

    beforeTest {
        bigachu = createBakemon()
    }

    "A Bakémon" - {
        "should have a name" {
            bigachu.name shouldBe BAKEMON_NAME
        }

        "should have health points" {
            bigachu.healthPoints shouldBe BAKEMON_HEALTH
        }
    }
})

private fun createBakemon(): Bakemon = object : AbstractBakemon(BAKEMON_NAME, BAKEMON_HEALTH) {}
