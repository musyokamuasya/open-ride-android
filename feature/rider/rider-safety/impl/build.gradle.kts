plugins {
    alias(libs.plugins.openride.android.feature)
}

android {
    namespace = "com.openrideafrica.feature.rider.ridersafety.impl"
}

dependencies {
    implementation(project(":feature:rider:rider-safety:api"))
    implementation(project(":core:data"))
    implementation(project(":core:location"))
}