rootProject.name = "example-based-testing-kt"

pluginManagement { // Configuración de gestión de plugins
    includeBuild("convention-plugins") // Incluye un archivo de configuración de plugins
    repositories {  // Repositorios de plugins
        mavenCentral()
        gradlePluginPortal()
    }
}

dependencyResolutionManagement {    // Gestión de resolución de dependencias
    @Suppress("UnstableApiUsage")   // Necesario para usar la API de resolución de dependencias
    repositories {
        mavenCentral()  // Repositorio Maven Central
    }
}

include(
    ":bakemon",
    ":test-basics",
    ":test-utils",
    ":test-exceptions",
    ":data-driven-testing"
)
