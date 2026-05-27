plugins {
    alias(libs.plugins.openride.android.feature)
}

android {
    namespace = "com.openrideafrica.feature.driver.driverhome.impl"
}

dependencies {
    implementation(project(":feature:driver:driver-home:api"))
    implementation(project(":core:data"))
}