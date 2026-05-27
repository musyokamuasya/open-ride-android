plugins {
    alias(libs.plugins.openride.android.feature)
}

android {
    namespace = "com.openrideafrica.feature.shared.notifications.impl"
}

dependencies {
    implementation(project(":feature:shared:notifications:api"))
    implementation(project(":core:data"))
    implementation(project(":core:notifications"))
}