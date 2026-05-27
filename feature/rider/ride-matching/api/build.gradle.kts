plugins {
    id("com.android.library")
}

android {
    namespace = "com.openrideafrica.feature.rider.ridematching.api"
    compileSdk = 36

    defaultConfig {
        minSdk = 26
        consumerProguardFiles("proguard-rules.pro")
    }

    buildTypes {
        release {
            isMinifyEnabled = false
        }
    }
}

dependencies {
    implementation(project(":core:model"))
    implementation(project(":core:common"))
}
