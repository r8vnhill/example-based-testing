package cl.ravenhill.bakemon

import io.kotest.assertions.throwables.shouldThrowUnit
import io.kotest.core.spec.style.FreeSpec
import io.kotest.datatest.withData
import io.kotest.matchers.shouldBe

class BakemonDDTest : FreeSpec({

    "A Bakémon" - {
        "should have current health property that" - {
            "should be settable to a value outside the valid range" - {
                withData(-100, -1, 101, 1000) { invalidHp ->
                    shouldThrowUnit<IllegalArgumentException> {
                        createBakemon("Bigachu", 100).currentHealthPoints = invalidHp
                    }.message shouldBe "Current health points is not in [0, 100]: $invalidHp"
                }
            }
        }

        "should be able to attack another Bakémon" - {
            withData("Bigachu", "Psygoose") { attackerName ->
                withData("Bigachu", "Psygoose") { targetName ->
                    withData(0, 1, 50, 99, 100) { attackerHealth ->
                        withData(0, 1, 50, 99, 100) { targetHealth ->
                            val attacker = createBakemon(attackerName, attackerHealth)
                            val target = createBakemon(targetName, targetHealth)

                            val initialTargetHealth = target.currentHealthPoints
                            attacker.attack(target)
                            val expectedDamage = 10
                            val expectedTargetHealth = initialTargetHealth - expectedDamage

                            target.currentHealthPoints shouldBe expectedTargetHealth
                        }
                    }
                }
            }
        }
    }
})
