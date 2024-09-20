package cl.ravenhill.bakemon

private const val BASE_DAMAGE = 10

abstract class AbstractBakemon(
    override val name: String,
    final override val maxHealthPoints: Int
) : Bakemon {
    override var currentHealthPoints: Int = maxHealthPoints
        set(value) {
            require(value in 0..maxHealthPoints) {
                "Current health points is not in [0, $maxHealthPoints]: $value"
            }
            field = value
        }

    override fun attack(target: Bakemon) = try {
        target.currentHealthPoints -= BASE_DAMAGE
    } catch (e: IllegalArgumentException) {
        println(e.message)
        target.currentHealthPoints = 0
    }
}
