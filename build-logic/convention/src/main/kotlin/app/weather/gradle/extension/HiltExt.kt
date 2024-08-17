package app.weather.gradle.extension

import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies

internal fun Project.configHilt() {
  pluginManager.apply("com.google.devtools.ksp")
  pluginManager.apply("com.google.dagger.hilt.android")

  dependencies {
    "implementation"(libs.findLibrary("hilt-android").get())
    "ksp"(libs.findLibrary("hilt-android-compiler").get())
  }
}
