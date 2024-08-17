package app.weather.gradle

import app.weather.gradle.extension.configComposeAndroid
import app.weather.gradle.extension.configHilt
import app.weather.gradle.extension.configKotlinAndroid
import com.android.build.api.dsl.ApplicationExtension
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure

@Suppress("unused")
class AndroidApplicationConventionPlugin : Plugin<Project> {
  override fun apply(target: Project) {
    with(target) {
      pluginManager.apply("com.android.application")
      pluginManager.apply("org.jetbrains.kotlin.android")

      extensions.configure<ApplicationExtension> {
        compileSdk = 34

        defaultConfig {
          minSdk = 24
          targetSdk = 34

          testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
          vectorDrawables {
            useSupportLibrary = true
          }
        }

        configKotlinAndroid(this)
        configComposeAndroid(this)
        configHilt()
      }
    }
  }
}
