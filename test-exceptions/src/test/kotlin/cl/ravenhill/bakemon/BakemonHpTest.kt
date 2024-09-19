package cl.ravenhill.bakemon

import io.kotest.assertions.throwables.shouldThrowUnit
import io.kotest.core.spec.style.FreeSpec
import io.kotest.matchers.shouldBe

private const val BAKEMON_NAME = "Bigachu"
private const val BAKEMON_MAX_HP = 100
private const val STARTING_CURRENT_HP = BAKEMON_MAX_HP
private const val NEW_CURRENT_HP = 50
private const val NEGATIVE_CURRENT_HP = -1
private const val OVER_MAX_CURRENT_HP = BAKEMON_MAX_HP + 1

class BakemonHpTest : FreeSpec({
    lateinit var bigachu: Bakemon

    beforeTest {
        bigachu = createBakemon(BAKEMON_NAME, BAKEMON_MAX_HP)
    }

    "A Bakémon" - {
        "should have a maximum health property" {
            bigachu.maxHealthPoints shouldBe BAKEMON_MAX_HP
        }

        "should have current health property that" - {
            "should start at the maximum health" {
                bigachu.currentHealthPoints shouldBe STARTING_CURRENT_HP
            }

            "should be settable to a non-negative value" {
                bigachu.currentHealthPoints = NEW_CURRENT_HP
                bigachu.currentHealthPoints shouldBe NEW_CURRENT_HP
            }

            "should not be settable to a negative value" {
                shouldThrowUnit<IllegalArgumentException> {
                    bigachu.currentHealthPoints = NEGATIVE_CURRENT_HP
                }.message shouldBe "Current health points is not in [0, $BAKEMON_MAX_HP]: $NEGATIVE_CURRENT_HP"
            }

            "should not be settable to a value greater than the maximum health" {
                shouldThrowUnit<IllegalArgumentException> {
                    bigachu.currentHealthPoints = OVER_MAX_CURRENT_HP
                }.message shouldBe "Current health points is not in [0, $BAKEMON_MAX_HP]: $OVER_MAX_CURRENT_HP"
            }
        }
    }
})
