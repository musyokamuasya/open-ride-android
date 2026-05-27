plugins {
    alias(libs.plugins.openride.android.feature)
}

android {
    namespace = "com.openrideafrica.feature.driver.drivernavigation.impl"
}

dependencies {
    implementation(project(":feature:driver:driver-navigation:api"))
    implementation(project(":core:data"))
    implementation(project(":core:maps"))
    implementation(project(":core:location"))
}