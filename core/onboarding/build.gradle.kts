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

    /*HILT*/
    implementation(Hilt.hiltAndroid)
    implementation(Image_Loading_Coil.LOTTIE)
    kapt(Hilt.hiltCompiler)
    kapt(Hilt.hiltAndroidCompiler)

}