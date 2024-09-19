package cl.ravenhill.bakemon

fun createBakemon(name: String, hp: Int): Bakemon = object : AbstractBakemon(name, hp) {}
