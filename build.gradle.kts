plugins {
    id("jvm.conventions")
    alias(libs.plugins.detekt)
}

val projectGroup = extra["example-based-testing.group"]!! // Throws an exception if the property is not found
val projectVersion: String = libs.versions.example.based.testing.get()
val detektId: String = libs.plugins.detekt.get().pluginId
val detektFormattingModule = libs.detekt.formatting.get().module.toString()
val detektFormattingVersion = libs.detekt.formatting.get().version

allprojects {
    group = projectGroup
    version = projectVersion
}

val kotestBundle = libs.bundles.kotest

subprojects {
    apply(plugin = "jvm.conventions")
    apply(plugin = detektId)

    dependencies {
        detektPlugins("$detektFormattingModule:$detektFormattingVersion")
        if (name != "bakemon") {
            implementation(kotestBundle)
            implementation(project(":bakemon"))
        }
    }
}
