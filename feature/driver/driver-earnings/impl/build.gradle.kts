plugins {
    alias(libs.plugins.openride.android.feature)
}

android {
    namespace = "com.openrideafrica.feature.driver.driverearnings.impl"
}

dependencies {
    implementation(project(":feature:driver:driver-earnings:api"))
    implementation(project(":core:data"))
}