plugins {
    alias(libs.plugins.openride.android.feature)
}

android {
    namespace = "com.openrideafrica.feature.rider.riderpayment.impl"
}

dependencies {
    implementation(project(":feature:rider:rider-payment:api"))
    implementation(project(":core:data"))
}