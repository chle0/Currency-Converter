buildscript { }

plugins {
    id("com.android.application") version Gradle.version apply false
    id("com.android.library") version Gradle.version apply false
    id("org.jetbrains.kotlin.android") version Kotlin.version apply false
    id ("com.google.dagger.hilt.android") version Hilt.DAGGER_VERSION apply false
}