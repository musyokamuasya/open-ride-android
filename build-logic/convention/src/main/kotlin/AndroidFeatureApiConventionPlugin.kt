import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.apply
import org.gradle.kotlin.dsl.dependencies

class AndroidFeatureApiConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            apply(plugin = "openride.android.library")
            apply(plugin = "openride.kotlin.serialization")

            dependencies {
                add("implementation", project(":core:model"))
            }
        }
    }
}