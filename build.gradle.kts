buildscript {

    repositories {
        google()
        jcenter()
    }

    dependencies {
        classpath(Gradle.android_tools)
        classpath(Gradle.kotlin_plugin)
        classpath(Gradle.dagger_hilt_plugin)
        classpath(Gradle.android_safe_arg_plugin)
    }
}

allprojects {
    repositories {
        google()
        jcenter()
        maven{
            url = uri("https://jitpack.io")
        }
    }
}

tasks.register("clean", Delete::class.java){
    delete(rootProject.buildDir)
}