package cl.ravenhill.bakemon

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
}
