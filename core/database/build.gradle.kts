plugins {
    alias(libs.plugins.openride.android.library)
    alias(libs.plugins.openride.android.room)
    alias(libs.plugins.openride.hilt)
}

android {
    namespace = "com.openrideafrica.core.database"
}

dependencies {
    implementation(project(":core:model"))
}