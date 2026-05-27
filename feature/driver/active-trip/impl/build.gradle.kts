plugins {
    alias(libs.plugins.openride.android.feature)
}

android {
    namespace = "com.openrideafrica.feature.driver.activetrip.impl"
}

dependencies {
    implementation(project(":feature:driver:active-trip:api"))
    implementation(project(":core:data"))
}