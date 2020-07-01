import org.gradle.api.Project
import org.gradle.kotlin.dsl.DependencyHandlerScope
import org.gradle.kotlin.dsl.dependencies


fun Project.addKotlinCoroutinesFlow(configurationName: String = "implementation") {
    dependencies {
        add(configurationName, Kotlin.stdlib)
        add(configurationName, Kotlin.coroutine_core)
        add(configurationName, Kotlin.coroutine_android)
        add(configurationName, Kotlin.coroutine_play_service)
    }
}

fun DependencyHandlerScope.addKotlinCoroutinesFlow(
    implementation: String = "implementation",
    kapt: String = "kapt"
) {
    add(implementation, Kotlin.stdlib)
    add(implementation, Kotlin.coroutine_core)
    add(implementation, Kotlin.coroutine_android)
    add(implementation, Kotlin.coroutine_play_service)
}