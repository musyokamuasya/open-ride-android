plugins {
    alias(libs.plugins.openride.android.feature)
}

android {
    namespace = "com.openrideafrica.feature.rider.ridematching.impl"
}

dependencies {
    implementation(project(":feature:rider:ride-matching:api"))
    implementation(project(":core:data"))
    implementation(project(":core:realtime"))
}