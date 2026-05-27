plugins {
    alias(libs.plugins.openride.android.feature)
}

android {
    namespace = "com.openrideafrica.feature.shared.support.impl"
}

dependencies {
    implementation(project(":feature:shared:support:api"))
    implementation(project(":core:data"))
}