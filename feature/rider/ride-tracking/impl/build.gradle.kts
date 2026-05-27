plugins {
    alias(libs.plugins.openride.android.feature)
}

android {
    namespace = "com.openrideafrica.feature.rider.ridetracking.impl"
}

dependencies {
    implementation(project(":feature:rider:ride-tracking:api"))
    implementation(project(":core:data"))
    implementation(project(":core:realtime"))
    implementation(project(":core:maps"))
}