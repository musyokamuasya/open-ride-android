plugins {
    alias(libs.plugins.openride.android.feature)
}

android {
    namespace = "com.openrideafrica.feature.rider.home.impl"
}

dependencies {
    implementation(project(":feature:rider:home:api"))
    implementation(project(":core:data"))
    implementation(project(":core:maps"))
    implementation(project(":core:location"))
}