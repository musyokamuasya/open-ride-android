plugins {
    alias(libs.plugins.openride.android.feature)
}

android {
    namespace = "com.openrideafrica.feature.rider.ridebooking.impl"
}

dependencies {
    implementation(project(":feature:rider:ride-booking:api"))
    implementation(project(":feature:rider:ride-matching:api"))
    implementation(project(":feature:rider:rider-payment:api"))
    implementation(project(":core:data"))
    implementation(project(":core:maps"))
}