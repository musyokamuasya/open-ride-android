plugins {
    alias(libs.plugins.openride.android.library)
    alias(libs.plugins.openride.kotlin.serialization)
    alias(libs.plugins.openride.hilt)
}

android {
    namespace = "com.openrideafrica.core.network"
    buildFeatures {
        buildConfig = true
    }
}

dependencies {
    implementation(project(":core:model"))
    implementation(libs.retrofit.core)
    implementation(libs.retrofit.serialization)
    implementation(libs.okhttp.core)
    implementation(libs.okhttp.logging)
}