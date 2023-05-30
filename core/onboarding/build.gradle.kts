plugins {
    id(BuildPlugins.ANDROID_LIBRARY_PLUGIN)
    id(BuildPlugins.KOTLIN_ANDROID_PLUGIN)
    id(BuildPlugins.KOTLIN_KAPT)
    id(BuildPlugins.DAGGER_HILT)
}

android {
    compileSdk = ProjectConfig.compileSdk

    defaultConfig {
        minSdk = ProjectConfig.minSdk
        targetSdk = ProjectConfig.targetSdk
    }

    buildFeatures {
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = Compose.kotlinCompilerExtensionVersion
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = Kotlin.jvmTarget
    }
}

dependencies {

    implementation(project(ModuleExt.Core_Ui))
    implementation(project(ModuleExt.Navigator))
    implementation(project(ModuleExt.Dto))
    implementation(project(ModuleExt.Network))

    implementation(Image_Loading_Coil.LOTTIE)

    api(Networking.RETROFIT)
    api(Networking.RETROFIT_GSON)
    implementation(Networking.LOGGING)

    implementation(Logger.TIMBER)

    /*HILT*/
    implementation(Hilt.hiltAndroid)
    kapt(Hilt.hiltCompiler)
    kapt(Hilt.hiltAndroidCompiler)

}