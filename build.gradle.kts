import org.jetbrains.kotlin.gradle.ExperimentalKotlinGradlePluginApi

plugins {
    alias(libs.plugins.kotlin.multiplatform)
    alias(libs.plugins.kotlinx.serialization)
    alias(libs.plugins.jetbrains.compose)
    alias(libs.plugins.jetbrains.compose.compiler)
}

group = "dev.limebeck"
version = "1.0.0"

repositories {
    mavenCentral()
}

kotlin {
    js {
        browser {
        }
        binaries.executable()
    }

    @OptIn(ExperimentalKotlinGradlePluginApi::class)
    compilerOptions {
        freeCompilerArgs.add(
            "-Xcontext-receivers",
        )
    }

    sourceSets {
        jsMain.dependencies {
            implementation(libs.kotlin.coroutines)
            implementation(libs.kotlin.extensions)
            implementation(libs.kotlinx.serialization.core)
            implementation(libs.kotlinx.serialization.json)
            implementation(compose.runtime)
            implementation(compose.html.core)
        }

        jsTest.dependencies {
            implementation(kotlin("test-js"))
        }
    }
}
