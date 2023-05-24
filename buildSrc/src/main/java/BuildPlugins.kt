object BuildPlugins {
    const val TOOLS_BUILD_GRADLE = "com.android.tools.build:gradle:7.2.1"
    const val DAGGER_HILT_PLUGIN = "com.google.dagger:hilt-android-gradle-plugin:2.43.2"
    const val KOTLIN_GRADLE_PLUGIN =
        "org.jetbrains.kotlin:kotlin-gradle-plugin:${Kotlin.version}"
    const val ANDROID_APPLICATION_PLUGIN = "com.android.application"
    const val ANDROID_LIBRARY_PLUGIN = "com.android.library"
    const val ANDROID_TEST_PLUGIN = "com.android.test"
    const val KOTLIN_ANDROID_PLUGIN = "kotlin-android"
    const val KOTLIN_PARCELABLE_PLUGIN = "kotlin-parcelize"
    const val KOTLIN_KAPT = "kotlin-kapt"
    const val DAGGER_HILT = "dagger.hilt.android.plugin"
}