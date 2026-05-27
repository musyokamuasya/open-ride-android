plugins {
    alias(libs.plugins.openride.android.feature)
}

android {
    namespace = "com.openrideafrica.feature.shared.auth.impl"
}

dependencies {
    implementation(project(":feature:shared:auth:api"))
    implementation(project(":core:data"))
    implementation(project(":core:datastore"))
    implementation(project(":core:network"))
}