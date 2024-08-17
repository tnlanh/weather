package app.weather.gradle.extension

import com.android.build.api.dsl.CommonExtension
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies

internal fun Project.configComposeAndroid(
  commonExtension: CommonExtension<*, *, *, *, *, *>,
) {
  pluginManager.apply("org.jetbrains.kotlin.plugin.compose")

  commonExtension.apply {
    buildFeatures {
      compose = true
    }

    dependencies {
      val bom = libs.findLibrary("androidx-compose-bom").get()

      "implementation"(platform(bom))
      "implementation"(libs.findLibrary("androidx-compose-ui").get())
      "implementation"(libs.findLibrary("androidx-compose-ui-graphics").get())
      "implementation"(libs.findLibrary("androidx-compose-ui-tooling-preview").get())
      "implementation"(libs.findLibrary("androidx-compose-material3").get())

      "androidTestImplementation"(platform(bom))
      "androidTestImplementation"(libs.findLibrary("androidx-compose-ui-test-junit4").get())

      "debugImplementation"(libs.findLibrary("androidx-compose-ui-tooling").get())
      "debugImplementation"(libs.findLibrary("androidx-compose-ui-test-manifest").get())
    }
  }
}
