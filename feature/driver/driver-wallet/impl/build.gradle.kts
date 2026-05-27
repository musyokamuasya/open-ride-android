plugins {
    alias(libs.plugins.openride.android.feature)
}

android {
    namespace = "com.openrideafrica.feature.driver.driverwallet.impl"
}

dependencies {
    implementation(project(":feature:driver:driver-wallet:api"))
    implementation(project(":core:data"))
}