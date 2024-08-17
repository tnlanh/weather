package app.weather.gradle

import app.weather.gradle.extension.configComposeAndroid
import app.weather.gradle.extension.configHilt
import app.weather.gradle.extension.configKotlinAndroid
import com.android.build.api.dsl.LibraryExtension
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure

@Suppress("unused")
class AndroidFeatureConventionPlugin : Plugin<Project> {
  override fun apply(target: Project) {
    with(target) {
      pluginManager.apply("com.android.library")
      pluginManager.apply("org.jetbrains.kotlin.android")

      extensions.configure<LibraryExtension> {
        compileSdk = 34

        defaultConfig {
          minSdk = 24

          testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        }

        configKotlinAndroid(this)
        configComposeAndroid(this)
        configHilt()
      }
    }
  }
}
