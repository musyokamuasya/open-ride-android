plugins {
    alias(libs.plugins.openride.android.feature)
}

android {
    namespace = "com.openrideafrica.feature.driver.vehicledocuments.impl"
}

dependencies {
    implementation(project(":feature:driver:vehicle-documents:api"))
    implementation(project(":core:data"))
}