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
    packagingOptions {
        resources.excludes.add("META-INF/LICENSE.txt")
        resources.excludes.add("META-INF/NOTICE.txt")
        resources.excludes.add("LICENSE.txt")
        resources.excludes.add("/META-INF/{AL2.0,LGPL2.1}")

        jniLibs {
            useLegacyPackaging = true
        }
    }
}

dependencies {

    implementation(project(ModuleExt.Utils))

    api(Image_Loading_Coil.COIL)
    api(Image_Loading_Coil.COIL_SVG)
    /*HILT*/
    implementation(Hilt.hiltAndroid)
    kapt(Hilt.hiltCompiler)
    kapt(Hilt.hiltAndroidCompiler)
    /*Kotlin*/
    api(Kotlin.KT_STD)
    api(Kotlin.KTX_CORE)
    /* Android Designing and layout */
    api(Compose.APP_COMPAT)
    api(Compose.MATERIAL_DESIGN)
    api(Compose.COMPOSE_UI)
    api(Accompanist.ACCOMPANIST_SYSTEM_UI_CONTROLLER)
    api(Compose.COMPOSE_MATERIAL)
    api(Compose.COMPOSE_TOOLING)
    api(Compose.COMPOSE_UTIL)
    debugApi(Compose.COMPOSE_DEBUG_TOOLING)
    api(Compose.activityCompose)
    api(Compose.VIEW_MODEL)
    api(Compose.CONSTRAINT_LAYOUT_COMPOSE)
    implementation(Image_Loading_Coil.LOTTIE)

    api(Accompanist.ACCOMPANIST_SWIPE_REFRESH)
    api(Accompanist.ACCOMPANIST_PERMISSION)

    api(Accompanist.VIEW_PAGER)
    api(Accompanist.VIEW_PAGER_INDICATOR)
    api(Accompanist.ACCOMPANIST_NAVIGATION_MATERIAL)
    api(Accompanist.ACCOMPANIST_PLACE_HOLDER){
        exclude(group = "androidx.compose.material", module = "material")
        exclude(group = "androidx.compose.ui", module = "ui-util")
    }
}