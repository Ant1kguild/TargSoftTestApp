object Versions {
    const val android_core = "1.3.0"
    const val android_appcompat = "1.1.0"
    const val android_legacy_support = "1.0.0"
    const val android_lifecycle = "2.2.0"
    const val android_fragment = "1.3.0-alpha06"
    const val android_constraint_layout = "1.1.3"
    const val android_vector_drawable = "1.1.0"
    const val android_paging_runtime = "3.0.0-alpha02"
    const val android_test_espresso_core = "3.2.0"
    const val android_test_junit = "1.1.1"
    const val dagger_hilt = "2.28-alpha"
    const val coil = "0.11.0"
    const val firebase_auth = "19.3.1"
    const val firebase_analytics = "17.4.3"
    const val firebase_database = "19.3.1"
    const val firebase_storage = "19.1.1"
    const val gradle = "4.0.0"
    const val google_material_design = "1.3.0-alpha01"
    const val google_gms_service = "4.3.3"
    const val google_play_service = "17.0.0"
    const val kotlin = "1.3.72"
    const val kotlin_coroutines = "1.3.7"
    const val koin = "2.1.5"
    const val layout_switch_icon = "1.4.0"
    const val layout_overwatch_progress_bar = "1.6"
    const val lib_recyclerview_divider = "3.3.0"
    const val moshi = "1.9.2"
    const val okhttp = "4.7.2"
    const val navigation = "2.3.0"
    const val retrofit = "2.8.2"
    const val room = "2.2.5"
    const val test_junit = "4.13"

}

object Gradle {
    const val android_tools = "com.android.tools.build:gradle:${Versions.gradle}"
    const val kotlin_plugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlin}"
    const val android_safe_arg_plugin = "androidx.navigation:navigation-safe-args-gradle-plugin:${Versions.navigation}"
    const val dagger_hilt_plugin = "com.google.dagger:hilt-android-gradle-plugin:${Versions.dagger_hilt}"
}

object Kotlin {
    const val stdlib = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${Versions.kotlin}"
    const val coroutine_core = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.kotlin_coroutines}"
    const val coroutine_android = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.kotlin_coroutines}"
    const val coroutine_play_service = "org.jetbrains.kotlinx:kotlinx-coroutines-play-services:${Versions.kotlin_coroutines}"
}

object Android {
    const val constraint_layout = "androidx.constraintlayout:constraintlayout:${Versions.android_constraint_layout}"
    const val core = "androidx.core:core-ktx:${Versions.android_core}"
    const val appcompat = "androidx.appcompat:appcompat:${Versions.android_appcompat}"
    const val fragment = "androidx.fragment:fragment-ktx:${Versions.android_fragment}"
    const val legacy = "androidx.legacy:legacy-support-v4:${Versions.android_legacy_support}"
    const val lifecycle_extensions = "androidx.lifecycle:lifecycle-extensions:${Versions.android_lifecycle}"
    const val lifecycle_view_model = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.android_lifecycle}"
    const val lifecycle_livedata = "androidx.lifecycle:lifecycle-livedata-ktx:${Versions.android_lifecycle}"
    const val navigation_fragment = "androidx.navigation:navigation-fragment-ktx:${Versions.navigation}"
    const val navigation_ui = "androidx.navigation:navigation-ui-ktx:${Versions.navigation}"
    const val paging = "androidx.paging:paging-runtime:${Versions.android_paging_runtime}"
    const val vector_drawable = "androidx.vectordrawable:vectordrawable:${Versions.android_vector_drawable}"
}

object AndroidCostumeLibs {
    const val recyclerview_divider = "com.github.fondesa:recycler-view-divider:${Versions.lib_recyclerview_divider}"
}

object AndroidCostumeLayouts {
    const val switch_icon = "com.github.zagum:Android-SwitchIcon:${Versions.layout_switch_icon}"
    const val overwatch_progress_bar = "com.github.zjywill:OverwatchProgress:${Versions.layout_overwatch_progress_bar}"
}

object Google {
    const val gms_google_services = "com.google.gms:google-services:${Versions.google_gms_service}"
    const val location_service = "com.google.android.gms:play-services-location:${Versions.google_play_service}"
    const val map_service = "com.google.android.gms:play-services-maps:${Versions.google_play_service}"
    const val material_design = "com.google.android.material:material:${Versions.google_material_design}"
}

object Network {
    const val okhttp3_core = "com.squareup.okhttp3:okhttp:${Versions.okhttp}"
    const val okhttp3_logging_interceptor = "com.squareup.okhttp3:logging-interceptor:${Versions.okhttp}"
    const val retrofit2_core = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
    const val retrofit2_moshi_converter = "com.squareup.retrofit2:converter-moshi:${Versions.retrofit}"
    const val moshi_kotlin_core = "com.squareup.moshi:moshi-kotlin:${Versions.moshi}"
    const val moshi_codegen = "com.squareup.moshi:moshi-kotlin-codegen:${Versions.moshi}"
}

object DependencyInjection {
    const val koin_core = "org.koin:koin-android:${Versions.koin}"
    const val koin_view_model = "org.koin:koin-androidx-viewmodel:${Versions.koin}"
    const val hilt_core = "com.google.dagger:hilt-android:${Versions.dagger_hilt}"
    const val hilt_viewmodel = "androidx.hilt:hilt-lifecycle-viewmodel:${Versions.dagger_hilt}"
    const val hilt_compiler = "com.google.dagger:hilt-android-compiler:${Versions.dagger_hilt}"
}

object ImageLoader {
    const val coli = "io.coil-kt:coil:${Versions.coil}"
}

object Firebase {
    const val auth = "com.google.firebase:firebase-auth-ktx:${Versions.firebase_auth}"
    const val analytics = "com.google.firebase:firebase-analytics-ktx:${Versions.firebase_analytics}"
    const val database = "com.google.firebase:firebase-database-ktx:${Versions.firebase_database}"
    const val storage = "com.google.firebase:firebase-storage-ktx:${Versions.firebase_storage}"
}

object Room {
    const val runtime = "androidx.room:room-runtime:${Versions.room}"
    const val compiler = "androidx.room:room-compiler:${Versions.room}"
    const val room_ktx = "androidx.room:room-ktx:${Versions.room}"
}

object Test {
    const val junit = "junit:junit:${Versions.test_junit}"
}

object AndroidTest {
    const val junit = "androidx.test.ext:junit:${Versions.android_test_junit}"
    const val espresso = "androidx.test.espresso:espresso-core:${Versions.android_test_espresso_core}"
}