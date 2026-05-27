plugins {
    alias(libs.plugins.openride.android.library)
    alias(libs.plugins.openride.hilt)
}

android {
    namespace = "com.openrideafrica.core.notifications"
}

dependencies {
    implementation(project(":core:model"))
    implementation(project(":core:common"))
}