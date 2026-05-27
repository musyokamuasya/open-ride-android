plugins {
    alias(libs.plugins.openride.android.feature)
}

android {
    namespace = "com.openrideafrica.feature.rider.destinationsearch.impl"
}

dependencies {
    implementation(project(":feature:rider:destination-search:api"))
    implementation(project(":core:data"))
    implementation(project(":core:maps"))
}