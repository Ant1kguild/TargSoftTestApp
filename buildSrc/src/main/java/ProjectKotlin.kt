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