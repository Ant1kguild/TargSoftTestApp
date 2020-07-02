import org.gradle.kotlin.dsl.DependencyHandlerScope


fun DependencyHandlerScope.addKotlinCoroutines(
    implementation: String = "implementation"
) {
    add(implementation, Kotlin.stdlib)
    add(implementation, Kotlin.coroutine_core)
    add(implementation, Kotlin.coroutine_android)
}


fun DependencyHandlerScope.addNetWork(
    implementation: String = "implementation",
    kapt: String = "kapt"
) {
    add(implementation, Network.okhttp3_core)
    add(implementation, Network.okhttp3_logging_interceptor)
    add(implementation, Network.retrofit2_core)
    add(implementation, Network.retrofit2_moshi_converter)
    add(implementation, Network.moshi_kotlin_core)
    add(kapt, Network.moshi_codegen)
}

fun DependencyHandlerScope.addDaggerHilt(
    implementation: String = "implementation",
    kapt: String = "kapt"
) {
    add(implementation, DependencyInjection.hilt_core)
    add(kapt, DependencyInjection.hilt_compiler)
}

fun DependencyHandlerScope.addAndroid(
    implementation: String = "implementation",
    kapt: String = "kapt"
) {
    add(implementation, Android.core)
    add(implementation, Android.appcompat)
    add(implementation, Android.constraint_layout)
    add(implementation, Android.vector_drawable)
    add(implementation, Google.material_design)
    add(implementation, Android.lifecycle_extensions)
    add(implementation, Android.lifecycle_view_model)
    add(implementation, Android.lifecycle_livedata)
    add(implementation, Android.navigation_fragment)
    add(implementation, Android.navigation_ui)
}