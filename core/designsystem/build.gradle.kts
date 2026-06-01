plugins {
    alias(libs.plugins.openride.android.library)
    alias(libs.plugins.openride.android.library.compose)
}


android {
    namespace = "com.openrideafrica.core.designsystem"
}

dependencies {
    implementation(libs.androidx.material3)
}