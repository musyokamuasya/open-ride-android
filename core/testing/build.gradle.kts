plugins {
    alias(libs.plugins.openride.android.library)
    alias(libs.plugins.openride.hilt)
}

android {
    namespace = "com.openrideafrica.core.testing"
}

dependencies {
    implementation(project(":core:model"))
    implementation(project(":core:data"))
    implementation(project(":core:domain"))
    implementation(libs.kotlinx.coroutines.test)
    implementation(libs.turbine)
    implementation(libs.mockk.android)
    implementation(libs.mockk.agent)
    implementation(libs.hilt.android.testing)
}