plugins {
    alias(libs.plugins.openride.android.feature)
}

android {
    namespace = "com.openrideafrica.feature.driver.driveravailability.impl"
}

dependencies {
    implementation(project(":feature:driver:driver-availability:api"))
    implementation(project(":core:data"))
}