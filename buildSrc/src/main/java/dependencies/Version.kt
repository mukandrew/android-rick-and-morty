package dependencies

object Version {
    // android Configuration
    object App {
        const val compileSdk = 31
        const val minSdk = 23
        const val targetSdk = 31
        const val versionCode = 1
        const val versionName = "1.0.0"
        const val ktlint = "0.42.1"
    }

    object ClassPaths {
        const val hilt = "2.39.1"
        const val gradle = "7.0.2"
        const val kotlin = "1.5.21"
        const val apollo = "2.5.9"
    }

    // Libraries
    object Kotlin {
        const val coroutine = "1.5.2"
    }

    object Test {
        const val jUnit = "4.13.2"
        const val androidJUnit = "1.1.3"
        const val androidEspresso = "3.4.0"
        const val mockk = "1.12.0"
        const val kotest = "4.6.3"
    }

    object Compose {
        const val general = "1.0.1"
        const val activity = "1.3.1"
    }

    object Android {
        const val core = "1.6.0"
        const val appcompat = "1.3.1"
        const val material = "1.4.0"
    }

    object Ktx {
        const val lifecycle = "2.3.1"
        const val fragment = "1.3.6"
        const val viewModel = "2.3.1"
    }

    object Room {
        const val general = "2.3.0"
    }

    object Hilt {
        const val lifecycle = "1.0.0-alpha01"
    }
}
