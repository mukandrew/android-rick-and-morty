package dependencies

object Dependencies {
    // path to common dependencies
    const val common = "../common.gradle"

    // path to local dependencies
    const val dependency = "./gradleScript/dependencies.gradle"

    // ktlint
    const val ktlintGradle = "../ktlint.gradle"
    const val ktlint = "com.pinterest:ktlint:${Version.App.ktlint}"

    object Plugins {
        const val Hilt = "dagger.hilt.android.plugin"
    }

    object ClassPaths {
        const val gradle = "com.android.tools.build:gradle:${Version.ClassPaths.gradle}"
        const val kotlin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Version.ClassPaths.kotlin}"
        const val apollo =
            "com.apollographql.apollo:apollo-gradle-plugin:${Version.ClassPaths.apollo}"
        const val hilt = "com.google.dagger:hilt-android-gradle-plugin:${Version.ClassPaths.hilt}"
    }

    object Modules {
        const val presentation = ":presentation"
        const val domain = ":domain"
        const val data = ":data"
        const val cache = ":cache"
        const val remote = ":remote"
        const val common = ":common"
    }

    // Libraries
    object Kotlin {
        const val coroutine =
            "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Version.Kotlin.coroutine}"
        const val androidCoroutine =
            "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Version.Kotlin.coroutine}"
    }

    object Test {
        const val jUnit = "junit:junit:${Version.Test.jUnit}"
        const val androidJUnit = "androidx.test.ext:junit:${Version.Test.androidJUnit}"
        const val androidEspresso =
            "androidx.test.espresso:espresso-core:${Version.Test.androidEspresso}"
        const val androidCompose = "androidx.compose.ui:ui-test-junit4:${Version.Compose.general}"
        const val debugCompose = "androidx.compose.ui:ui-tooling:${Version.Compose.general}"
        const val room = "androidx.room:room-testing:${Version.Room.general}"
        const val mockk = "io.mockk:mockk:${Version.Test.mockk}"
        const val coroutine =
            "org.jetbrains.kotlinx:kotlinx-coroutines-test:${Version.Kotlin.coroutine}"
        const val kotest = "io.kotest:kotest-assertions-core:${Version.Test.kotest}"
        const val kotestProperty = "io.kotest:kotest-property:${Version.Test.kotest}"
    }

    object Compose {
        const val ui = "androidx.compose.ui:ui:${Version.Compose.general}"
        const val animation = "androidx.compose.animation:animation:${Version.Compose.general}"
        const val material = "androidx.compose.material:material:${Version.Compose.general}"
        const val tooling = "androidx.compose.ui:ui-tooling-preview:${Version.Compose.general}"
        const val foundation = "androidx.compose.foundation:foundation:${Version.Compose.general}"
        const val activity = "androidx.activity:activity-compose:${Version.Compose.activity}"
        const val viewModel =
            "androidx.lifecycle:lifecycle-viewmodel-compose:${Version.Compose.viewModel}"
    }

    object Android {
        const val appcompat = "androidx.appcompat:appcompat:${Version.Android.appcompat}"
        const val material = "com.google.android.material:material:${Version.Android.material}"
    }

    object Ktx {
        const val core = "androidx.core:core-ktx:${Version.Android.core}"
        const val viewmodel = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Version.Ktx.viewModel}"
        const val room = "androidx.room:room-ktx:${Version.Room.general}"
        const val fragment = "androidx.fragment:fragment-ktx:${Version.Ktx.fragment}"
        const val lifecycle = "androidx.lifecycle:lifecycle-runtime-ktx:${Version.Ktx.lifecycle}"
    }

    object Apollo {
        const val runtime = "com.apollographql.apollo:apollo-runtime:${Version.ClassPaths.apollo}"
        const val coroutinesSupport =
            "com.apollographql.apollo:apollo-coroutines-support:${Version.ClassPaths.apollo}"
    }

    object Room {
        const val runtime = "androidx.room:room-runtime:${Version.Room.general}"
        const val compiler = "androidx.room:room-compiler:${Version.Room.general}"
    }

    object Hilt {
        const val android = "com.google.dagger:hilt-android:${Version.ClassPaths.hilt}"
        const val androidCompiler =
            "com.google.dagger:hilt-android-compiler:${Version.ClassPaths.hilt}"
        const val viewModel = "androidx.hilt:hilt-lifecycle-viewmodel:${Version.Hilt.viewModel}"
        const val viewModelCompiler = "androidx.hilt:hilt-compiler:${Version.Hilt.viewModel}"
    }
}
