plugins {
  alias(libs.plugins.android.application) apply false
  alias(libs.plugins.android.library) apply false
  alias(libs.plugins.kotlin.android) apply false
  alias(libs.plugins.kotlin.compose.compiler) apply false
  alias(libs.plugins.ksp) apply false
  alias(libs.plugins.hilt.android) apply false
  alias(libs.plugins.spotless)
}

spotless {
  val ktlintVersion = libs.versions.ktlint.get()
  kotlin {
    target("**/*.kt")
    targetExclude("**/build/**/*.kt")
    ktlint(ktlintVersion)
  }
  kotlinGradle {
    target("**/*.kts")
    targetExclude("**/build/**/*.kts")
    ktlint(ktlintVersion)
  }
  format("xml") {
    target("**/*.xml")
    targetExclude("**/build/**/*.xml")
    licenseHeader("<?xml version=\"1.0\" encoding=\"utf-8\"?>", "(<[^!?])")
  }
}
