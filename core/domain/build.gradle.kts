plugins {
    alias(libs.plugins.openride.android.library)
    alias(libs.plugins.openride.hilt)
}

android {
    namespace = "com.openrideafrica.core.domain"
}

dependencies {
    implementation(project(":core:model"))
    implementation(project(":core:data"))
    implementation(libs.kotlinx.coroutines.core)
}