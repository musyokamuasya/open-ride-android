plugins {
    alias(libs.plugins.openride.android.feature)
}

android {
    namespace = "com.openrideafrica.feature.shared.profile.impl"
}

dependencies {
    implementation(project(":feature:shared:profile:api"))
    implementation(project(":core:data"))
    implementation(project(":core:datastore"))
}