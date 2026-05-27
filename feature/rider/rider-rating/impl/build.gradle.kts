plugins {
    alias(libs.plugins.openride.android.feature)
}

android {
    namespace = "com.openrideafrica.feature.rider.riderrating.impl"
}

dependencies {
    implementation(project(":feature:rider:rider-rating:api"))
    implementation(project(":core:data"))
}