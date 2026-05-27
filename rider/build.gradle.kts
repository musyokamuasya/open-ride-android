plugins {
    alias(libs.plugins.openride.android.application)
    alias(libs.plugins.openride.android.application.compose)
    alias(libs.plugins.openride.hilt)
}

android {
    namespace = "com.openrideafrica.rider"
    defaultConfig {
        applicationId = "com.openrideafrica.rider"
        versionCode = 1
        versionName = "1.0"
    }
}

dependencies {
    implementation(libs.androidx.activity.compose)
    implementation(libs.androidx.core.ktx)
    implementation(libs.bundles.compose)
}