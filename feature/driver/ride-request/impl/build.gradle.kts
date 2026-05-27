plugins {
    alias(libs.plugins.openride.android.feature)
}

android {
    namespace = "com.openrideafrica.feature.driver.riderequest.impl"
}

dependencies {
    implementation(project(":feature:driver:ride-request:api"))
    implementation(project(":core:data"))
    implementation(project(":core:realtime"))
}