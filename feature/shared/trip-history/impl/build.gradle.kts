plugins {
    alias(libs.plugins.openride.android.feature)
}

android {
    namespace = "com.openrideafrica.feature.shared.triphistory.impl"
}

dependencies {
    implementation(project(":feature:shared:trip-history:api"))
    implementation(project(":core:data"))
    implementation(project(":core:database"))
}