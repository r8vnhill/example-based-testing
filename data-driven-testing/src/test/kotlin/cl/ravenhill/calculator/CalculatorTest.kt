package cl.ravenhill.calculator

import io.kotest.core.spec.style.FreeSpec
import io.kotest.datatest.withData
import io.kotest.matchers.shouldBe

class CalculatorTest : FreeSpec({
    "A calculator" - {
        "can apply a combination of operations" - {
            withData(1, 2, 3, 4) { a ->
                withData(1, 2, 3, 4) { b ->
                    withData(
                        a + b to { x: Int, y: Int -> x + y },
                        a - b to { x: Int, y: Int -> x - y }
                    ) { (expectedResult, operation) ->
                        val result = operation(a, b)
                        result shouldBe expectedResult
                    }
                }
            }
        }
    }
})
