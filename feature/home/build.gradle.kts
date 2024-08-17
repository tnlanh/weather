plugins {
  alias(libs.plugins.weather.android.feature)
}

android {
  namespace = "app.weather.feature.home"
}

dependencies {
  implementation(projects.core.common)
}
