plugins {
    id(BuildPlugins.ANDROID_LIBRARY_PLUGIN)
    id(BuildPlugins.KOTLIN_ANDROID_PLUGIN)
    id(BuildPlugins.KOTLIN_KAPT)
}

android {
    compileSdk = ProjectConfig.compileSdk

    defaultConfig {
        minSdk = ProjectConfig.minSdk
        targetSdk = ProjectConfig.targetSdk
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = Kotlin.jvmTarget
    }

    composeOptions {
        kotlinCompilerExtensionVersion = Compose.kotlinCompilerExtensionVersion
    }
}

// Required for annotation processing plugins like Dagger
kapt {
    correctErrorTypes = true
}

dependencies {
    api(Compose.COMPOSE_LIVEDATA)

    /*Kotlin*/
    api(Coroutines.COROUTINES)
    api(Coroutines.COROUTINES_ANDROID)
    api(Compose.COMPOSE_NAVIGATION)
    api(Hilt.hiltNavigationCompose)

    /*HILT*/
    implementation(Hilt.hiltAndroid)
    kapt(Hilt.hiltCompiler)
    kapt(Hilt.hiltAndroidCompiler)
}