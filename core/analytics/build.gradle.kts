plugins {
    alias(libs.plugins.openride.android.library)
}

android {
    namespace = "com.openrideafrica.core.analytics"
}

dependencies {
    implementation(project(":core:model"))
    implementation(project(":core:common"))
}