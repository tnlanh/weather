import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
  `kotlin-dsl`
}

group = "app.weather.gradle"

java {
  sourceCompatibility = JavaVersion.VERSION_17
  targetCompatibility = JavaVersion.VERSION_17
}

kotlin {
  compilerOptions {
    jvmTarget = JvmTarget.JVM_17
  }
}

dependencies {
  compileOnly(libs.android.gradle.plugin)
  compileOnly(libs.kotlin.gradle.plugin)
}

gradlePlugin {
  plugins {
    register("androidApplication") {
      id = "app.weather.android.application"
      implementationClass = "app.weather.gradle.AndroidApplicationConventionPlugin"
    }
    register("androidCore") {
      id = "app.weather.android.core"
      implementationClass = "app.weather.gradle.AndroidCoreConventionPlugin"
    }
    register("androidFeature") {
      id = "app.weather.android.feature"
      implementationClass = "app.weather.gradle.AndroidFeatureConventionPlugin"
    }
  }
}
