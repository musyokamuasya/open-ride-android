pluginManagement {
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
        mavenCentral()
        gradlePluginPortal()
    }
}
plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version "1.0.0"
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "Open Ride"
include(":app")
include(":driver")
include(":core:model")
include(":core:common")
include(":core:designsystem")
include(":core:ui")
include(":core:domain")
include(":core:data")
include(":core:network")
include(":core:database")
include(":core:datastore")
include(":core:realtime")
include(":core:location")
include(":core:maps")
include(":core:notifications")
include(":core:sync")
include(":core:analytics")
include(":core:testing")
include(":feature:shared:auth:api")
include(":feature:shared:auth:impl")
include(":feature:shared:profile:api")
include(":feature:shared:profile:impl")
include(":feature:shared:trip-history:api")
include(":feature:shared:trip-history:impl")
include(":feature:shared:support:api")
include(":feature:shared:support:impl")
include(":feature:shared:notifications:api")
include(":feature:shared:notifications:impl")
include(":feature:rider:home:api")
include(":feature:rider:home:impl")
include(":feature:rider:destination-search:api")
include(":feature:rider:destination-search:impl")
include(":feature:rider:ride-booking:api")
include(":feature:rider:ride-booking:impl")
include(":feature:rider:ride-matching:api")
include(":feature:rider:ride-matching:impl")
include(":feature:rider:ride-tracking:api")
include(":feature:rider:ride-tracking:impl")
include(":feature:rider:rider-payment:api")
include(":feature:rider:rider-payment:impl")
include(":feature:rider:rider-safety:api")
include(":feature:rider:rider-safety:impl")
include(":feature:rider:rider-rating:api")
include(":feature:rider:rider-rating:impl")
include(":feature:driver:driver-home:api")
include(":feature:driver:driver-home:impl")
include(":feature:driver:driver-availability:api")
include(":feature:driver:driver-availability:impl")
include(":feature:driver:ride-request:api")
include(":feature:driver:ride-request:impl")
include(":feature:driver:driver-navigation:api")
include(":feature:driver:driver-navigation:impl")
include(":feature:driver:active-trip:api")
include(":feature:driver:active-trip:impl")
include(":feature:driver:driver-earnings:api")
include(":feature:driver:driver-earnings:impl")
include(":feature:driver:driver-wallet:api")
include(":feature:driver:driver-wallet:impl")
include(":feature:driver:vehicle-documents:api")
include(":feature:driver:vehicle-documents:impl")
include(":feature:driver:driver-rating:api")
include(":feature:driver:driver-rating:impl")
