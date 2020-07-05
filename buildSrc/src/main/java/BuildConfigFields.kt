//import org.gradle.api.internal.GradleInternal.BuildType
//
//fun BaseFlavor.buildConfigBoolean(name: String, value: Boolean) =
//    buildConfigField("Boolean", name, value.toString())
//
//fun BaseFlavor.buildConfigString(name: String, value: String) =
//    buildConfigField("String", name, "\"$value\"")
//
//fun BuildType.buildConfigString(name: String, value: String) =
//    buildConfigField("String", name, "\"$value\"")