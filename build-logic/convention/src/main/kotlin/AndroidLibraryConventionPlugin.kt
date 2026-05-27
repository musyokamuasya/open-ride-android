import com.android.build.api.dsl.LibraryExtension
import com.android.build.api.variant.LibraryAndroidComponentsExtension
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.apply
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.dependencies

class AndroidLibraryConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            apply(plugin = "com.android.library")

            extensions.configure<LibraryExtension> {
                configureKotlinAndroid(this)
                defaultConfig.consumerProguardFiles("consumer-rules.pro")
                defaultConfig.testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
                testOptions.animationsDisabled = true
                testOptions.targetSdk = 36
                buildFeatures.buildConfig = false
                // Resources inside ":core:database" must be prefixed with "core_database_"
                resourcePrefix =
                    path.split("""\W""".toRegex()).drop(1).distinct()
                        .joinToString(separator = "_").lowercase() + "_"
            }

            extensions.configure<LibraryAndroidComponentsExtension> {
                beforeVariants {
                    it.androidTest.enable = it.androidTest.enable &&
                            target.projectDir.resolve("src/androidTest").exists()
                }
            }

            dependencies {
                "testImplementation"(libs.findLibrary("junit").get())
            }
        }
    }
}