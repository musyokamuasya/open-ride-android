#!/usr/bin/env bash
set -euo pipefail

COMPILE_SDK="${COMPILE_SDK:-36}"
MIN_SDK="${MIN_SDK:-26}"
TARGET_SDK="${TARGET_SDK:-36}"

APP_MODULES=(
  ":app:rider"
  ":app:driver"
)

CORE_MODULES=(
  ":core:model"
  ":core:common"
  ":core:designsystem"
  ":core:ui"
  ":core:domain"
  ":core:data"
  ":core:network"
  ":core:database"
  ":core:datastore"
  ":core:realtime"
  ":core:location"
  ":core:maps"
  ":core:notifications"
  ":core:sync"
  ":core:analytics"
  ":core:testing"
)

SHARED_FEATURE_MODULES=(
  ":feature:shared:auth:api"
  ":feature:shared:auth:impl"
  ":feature:shared:profile:api"
  ":feature:shared:profile:impl"
  ":feature:shared:trip-history:api"
  ":feature:shared:trip-history:impl"
  ":feature:shared:support:api"
  ":feature:shared:support:impl"
  ":feature:shared:notifications:api"
  ":feature:shared:notifications:impl"
)

RIDER_FEATURE_MODULES=(
  ":feature:rider:home:api"
  ":feature:rider:home:impl"
  ":feature:rider:destination-search:api"
  ":feature:rider:destination-search:impl"
  ":feature:rider:ride-booking:api"
  ":feature:rider:ride-booking:impl"
  ":feature:rider:ride-matching:api"
  ":feature:rider:ride-matching:impl"
  ":feature:rider:ride-tracking:api"
  ":feature:rider:ride-tracking:impl"
  ":feature:rider:rider-payment:api"
  ":feature:rider:rider-payment:impl"
  ":feature:rider:rider-safety:api"
  ":feature:rider:rider-safety:impl"
  ":feature:rider:rider-rating:api"
  ":feature:rider:rider-rating:impl"
)

DRIVER_FEATURE_MODULES=(
  ":feature:driver:driver-home:api"
  ":feature:driver:driver-home:impl"
  ":feature:driver:driver-availability:api"
  ":feature:driver:driver-availability:impl"
  ":feature:driver:ride-request:api"
  ":feature:driver:ride-request:impl"
  ":feature:driver:driver-navigation:api"
  ":feature:driver:driver-navigation:impl"
  ":feature:driver:active-trip:api"
  ":feature:driver:active-trip:impl"
  ":feature:driver:driver-earnings:api"
  ":feature:driver:driver-earnings:impl"
  ":feature:driver:driver-wallet:api"
  ":feature:driver:driver-wallet:impl"
  ":feature:driver:vehicle-documents:api"
  ":feature:driver:vehicle-documents:impl"
  ":feature:driver:driver-rating:api"
  ":feature:driver:driver-rating:impl"
)

ALL_MODULES=(
  "${APP_MODULES[@]}"
  "${CORE_MODULES[@]}"
  "${SHARED_FEATURE_MODULES[@]}"
  "${RIDER_FEATURE_MODULES[@]}"
  "${DRIVER_FEATURE_MODULES[@]}"
)

module_to_path() {
  local module="$1"
  echo "${module#:}" | tr ':' '/'
}

module_to_namespace() {
  local module="$1"

  if [[ "$module" == ":app:rider" ]]; then
    echo "com.openrideafrica.rider"
    return
  fi

  if [[ "$module" == ":app:driver" ]]; then
    echo "com.openrideafrica.driver"
    return
  fi

  local namespace="${module#:}"
  namespace="${namespace//:/\.}"
  namespace="${namespace//-/}"
  echo "com.openrideafrica.${namespace}"
}

write_if_missing() {
  local file="$1"
  shift

  if [[ -f "$file" ]]; then
    echo "Skipped existing $file"
    return
  fi

  mkdir -p "$(dirname "$file")"
  cat > "$file" "$@"
  echo "Created $file"
}

create_gitignore() {
  local dir="$1"

  write_if_missing "$dir/.gitignore" <<'CONTENT'
/build/
/.cxx/
captures/
*.iml
CONTENT
}

create_proguard() {
  local dir="$1"

  write_if_missing "$dir/proguard-rules.pro" <<'CONTENT'
# Add module-specific ProGuard or R8 rules here.
# Keep this file even when empty so every module has a consistent structure.
CONTENT
}

create_manifest() {
  local dir="$1"

  write_if_missing "$dir/src/main/AndroidManifest.xml" <<'CONTENT'
<manifest xmlns:android="http://schemas.android.com/apk/res/android" />
CONTENT
}

create_app_build_gradle() {
  local dir="$1"
  local namespace="$2"
  local application_id="$3"

  write_if_missing "$dir/build.gradle.kts" <<CONTENT
plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("org.jetbrains.kotlin.plugin.compose")
}

android {
    namespace = "$namespace"
    compileSdk = $COMPILE_SDK

    defaultConfig {
        applicationId = "$application_id"
        minSdk = $MIN_SDK
        targetSdk = $TARGET_SDK
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        debug {
            isMinifyEnabled = false
        }

        release {
            isMinifyEnabled = true
            isShrinkResources = true
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro",
            )
        }
    }

    buildFeatures {
        compose = true
    }
}

dependencies {
    implementation(project(":core:model"))
    implementation(project(":core:common"))
    implementation(project(":core:designsystem"))
    implementation(project(":core:ui"))
    implementation(project(":core:domain"))
    implementation(project(":core:data"))
    implementation(project(":core:analytics"))

    implementation(project(":feature:shared:auth:api"))
    implementation(project(":feature:shared:auth:impl"))
    implementation(project(":feature:shared:profile:api"))
    implementation(project(":feature:shared:profile:impl"))
    implementation(project(":feature:shared:support:api"))
    implementation(project(":feature:shared:support:impl"))
}
CONTENT
}

create_android_library_build_gradle() {
  local dir="$1"
  local namespace="$2"
  local module="$3"

  local compose_enabled="false"

  if [[ "$module" == *":impl" ]] || [[ "$module" == ":core:designsystem" ]] || [[ "$module" == ":core:ui" ]]; then
    compose_enabled="true"
  fi

  if [[ "$compose_enabled" == "true" ]]; then
    write_if_missing "$dir/build.gradle.kts" <<CONTENT
plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id("org.jetbrains.kotlin.plugin.compose")
}

android {
    namespace = "$namespace"
    compileSdk = $COMPILE_SDK

    defaultConfig {
        minSdk = $MIN_SDK
        consumerProguardFiles("proguard-rules.pro")
    }

    buildTypes {
        release {
            isMinifyEnabled = false
        }
    }

    buildFeatures {
        compose = true
    }
}

dependencies {
    implementation(project(":core:model"))
    implementation(project(":core:common"))
}
CONTENT
  else
    write_if_missing "$dir/build.gradle.kts" <<CONTENT
plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "$namespace"
    compileSdk = $COMPILE_SDK

    defaultConfig {
        minSdk = $MIN_SDK
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
CONTENT
  fi
}

patch_app_dependencies() {
  local rider_gradle="app/rider/build.gradle.kts"
  local driver_gradle="app/driver/build.gradle.kts"

  if [[ -f "$rider_gradle" ]] && ! grep -q ':feature:rider:home:impl' "$rider_gradle"; then
    python3 - <<'PY'
from pathlib import Path

path = Path("app/rider/build.gradle.kts")
text = path.read_text()

insert = '''
    implementation(project(":feature:rider:home:api"))
    implementation(project(":feature:rider:home:impl"))
    implementation(project(":feature:rider:destination-search:api"))
    implementation(project(":feature:rider:destination-search:impl"))
    implementation(project(":feature:rider:ride-booking:api"))
    implementation(project(":feature:rider:ride-booking:impl"))
    implementation(project(":feature:rider:ride-matching:api"))
    implementation(project(":feature:rider:ride-matching:impl"))
    implementation(project(":feature:rider:ride-tracking:api"))
    implementation(project(":feature:rider:ride-tracking:impl"))
    implementation(project(":feature:rider:rider-payment:api"))
    implementation(project(":feature:rider:rider-payment:impl"))
    implementation(project(":feature:rider:rider-safety:api"))
    implementation(project(":feature:rider:rider-safety:impl"))
    implementation(project(":feature:rider:rider-rating:api"))
    implementation(project(":feature:rider:rider-rating:impl"))
'''

marker = "}"
idx = text.rfind(marker)
text = text[:idx] + insert + text[idx:]
path.write_text(text)
PY
    echo "Patched rider app dependencies"
  fi

  if [[ -f "$driver_gradle" ]] && ! grep -q ':feature:driver:driver-home:impl' "$driver_gradle"; then
    python3 - <<'PY'
from pathlib import Path

path = Path("app/driver/build.gradle.kts")
text = path.read_text()

insert = '''
    implementation(project(":core:location"))
    implementation(project(":core:realtime"))

    implementation(project(":feature:driver:driver-home:api"))
    implementation(project(":feature:driver:driver-home:impl"))
    implementation(project(":feature:driver:driver-availability:api"))
    implementation(project(":feature:driver:driver-availability:impl"))
    implementation(project(":feature:driver:ride-request:api"))
    implementation(project(":feature:driver:ride-request:impl"))
    implementation(project(":feature:driver:driver-navigation:api"))
    implementation(project(":feature:driver:driver-navigation:impl"))
    implementation(project(":feature:driver:active-trip:api"))
    implementation(project(":feature:driver:active-trip:impl"))
    implementation(project(":feature:driver:driver-earnings:api"))
    implementation(project(":feature:driver:driver-earnings:impl"))
    implementation(project(":feature:driver:driver-wallet:api"))
    implementation(project(":feature:driver:driver-wallet:impl"))
    implementation(project(":feature:driver:vehicle-documents:api"))
    implementation(project(":feature:driver:vehicle-documents:impl"))
    implementation(project(":feature:driver:driver-rating:api"))
    implementation(project(":feature:driver:driver-rating:impl"))
'''

marker = "}"
idx = text.rfind(marker)
text = text[:idx] + insert + text[idx:]
path.write_text(text)
PY
    echo "Patched driver app dependencies"
  fi
}

add_settings_include() {
  local module="$1"

  if [[ ! -f "settings.gradle.kts" ]]; then
    echo "settings.gradle.kts not found"
    echo "Please create it first, then add include(\"$module\") manually"
    return
  fi

  if grep -q "include(\"$module\")" settings.gradle.kts; then
    echo "settings.gradle.kts already includes $module"
  else
    echo "include(\"$module\")" >> settings.gradle.kts
    echo "Added $module to settings.gradle.kts"
  fi
}

for module in "${ALL_MODULES[@]}"; do
  path="$(module_to_path "$module")"
  namespace="$(module_to_namespace "$module")"

  mkdir -p "$path/src/main/kotlin/$(echo "$namespace" | tr '.' '/')"

  create_gitignore "$path"
  create_proguard "$path"
  create_manifest "$path"

  if [[ "$module" == ":app:rider" ]]; then
    create_app_build_gradle "$path" "$namespace" "com.openrideafrica.rider"
  elif [[ "$module" == ":app:driver" ]]; then
    create_app_build_gradle "$path" "$namespace" "com.openrideafrica.driver"
  else
    create_android_library_build_gradle "$path" "$namespace" "$module"
  fi

  add_settings_include "$module"
done

patch_app_dependencies

echo ""
echo "Done."
echo ""
echo "Important next step"
echo "Make sure your root build.gradle.kts has these plugins declared with versions"
echo ""
echo 'plugins {'
echo '    id("com.android.application") version "<your-agp-version>" apply false'
echo '    id("com.android.library") version "<your-agp-version>" apply false'
echo '    id("org.jetbrains.kotlin.android") version "<your-kotlin-version>" apply false'
echo '    id("org.jetbrains.kotlin.plugin.compose") version "<your-kotlin-version>" apply false'
echo '}'
echo ""
echo "Then sync Gradle."
