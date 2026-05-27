plugins {
    alias(libs.plugins.openride.android.library)
    alias(libs.plugins.openride.hilt)
}

android {
    namespace = "com.openrideafrica.core.datastore"
}

dependencies {
    implementation(project(":core:model"))
    implementation(libs.androidx.datastore.preferences)
    implementation(libs.kotlinx.serialization.json)
}