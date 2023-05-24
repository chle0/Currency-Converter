object Compose {
    // BOM
    private const val bomVersion = "2022.10.00"
    const val bom = "androidx.compose:compose-bom:$bomVersion"
    private const val COMPOSE_VERSION = "1.3.1"
    private const val APP_COMPAT_VERSION = "1.5.1"
    private const val MATERIAL_DESIGN_VERSION = "1.5.0"
    private const val COMPOSE_ACTIVITY_VERSION = "1.6.1"
    private const val COMPOSE_CONSTRAINT_LAYOUT_VERSION = "1.0.1"
    private const val COMPOSE_NAVIGATION_VERSION = "2.5.3"
    private const val VIEW_MODEL_VERSION = "2.5.1"
    private const val WORK_RUNTIME_VERSION = "2.7.1"
    private const val BROADCAST_MANAGER_VERSION = "1.1.0"

    // UI
    const val ui = "androidx.compose.ui:ui"
    const val foundation = "androidx.compose.foundation:foundation"
    const val material2 = "androidx.compose.material:material"
    const val material3 = "androidx.compose.material3:material3"

    // Android Studio Preview Support
    const val uiTooling = "androidx.compose.ui:ui-tooling"
    const val uiToolingPreview = "androidx.compose.ui:ui-tooling-preview"

    // UI Tests
    const val uiTestJunit4 = "androidx.compose.ui:ui-test-junit4"
    const val uiTestManifest = "androidx.compose.ui:ui-test-manifest"

    // Activity
    private const val activityComposeVersion = "1.5.1"
    const val activityCompose = "androidx.activity:activity-compose:$activityComposeVersion"
    const val APP_COMPAT = "androidx.appcompat:appcompat:$APP_COMPAT_VERSION"

    // ViewModel
    private const val lifecycleViewModelComposeVersion = "2.5.1"
    const val lifecycleViewModelCompose = "androidx.lifecycle:lifecycle-viewmodel-compose:$lifecycleViewModelComposeVersion"

    // LiveData
    const val runtimeLiveData = "androidx.compose.runtime:runtime-livedata"

    // Kotlin Compiler
    const val kotlinCompilerExtensionVersion = "1.3.2"

    //Compose
    //Navigation
    //Lifecycle
    const val CONSTRAINT_LAYOUT_COMPOSE =
        "androidx.constraintlayout:constraintlayout-compose:$COMPOSE_CONSTRAINT_LAYOUT_VERSION"
    const val COMPOSE_UI = "androidx.compose.ui:ui:$COMPOSE_VERSION"
    const val COMPOSE_LIVEDATA = "androidx.compose.runtime:runtime-livedata:$COMPOSE_VERSION"
    const val COMPOSE_MATERIAL = "androidx.compose.material:material:$COMPOSE_VERSION"
    const val COMPOSE_FOUNDATION = "androidx.compose.foundation:foundation:$COMPOSE_VERSION"
    const val COMPOSE_TOOLING = "androidx.compose.ui:ui-tooling-preview:$COMPOSE_VERSION"
    const val COMPOSE_UTIL = "androidx.compose.ui:ui-util:$COMPOSE_VERSION"
    const val COMPOSE_DEBUG_TOOLING = "androidx.compose.ui:ui-tooling:$COMPOSE_VERSION"
    const val COMPOSE_NAVIGATION =
        "androidx.navigation:navigation-compose:$COMPOSE_NAVIGATION_VERSION"
    const val MATERIAL_DESIGN = "com.google.android.material:material:$MATERIAL_DESIGN_VERSION"
    const val VIEW_MODEL = "androidx.lifecycle:lifecycle-viewmodel-ktx:$VIEW_MODEL_VERSION"
    const val LIFE_CYCLE_SERVICE = "androidx.lifecycle:lifecycle-service:$VIEW_MODEL_VERSION"
    const val WORK_RUNTIME = "androidx.work:work-runtime:$WORK_RUNTIME_VERSION"
    const val BROADCAST_MANAGER =
        "androidx.localbroadcastmanager:localbroadcastmanager:$BROADCAST_MANAGER_VERSION"

    // App startup
    const val APP_STARTUP = "androidx.startup:startup-runtime:1.1.1"
    const val STRING_UTILS = "org.apache.commons:commons-lang3:3.11"
}