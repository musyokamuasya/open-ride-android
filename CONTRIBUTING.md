# Contributing to OpenRide Africa

Thank you for your interest in contributing to OpenRide Africa. This document explains how to get started, how the project is structured, and what to follow when submitting changes.

---

## Setting Up Your Development Environment

1. Install **Android Studio Meerkat** or newer.
2. Install **JDK 17**. Android Studio bundles a JDK but make sure your `JAVA_HOME` points to JDK 17.
3. Clone the repository:

```bash
git clone https://github.com/musyokamuasya/open-ride-android.git
cd open-ride-android
```

4. Open the project in Android Studio and wait for the Gradle sync to complete.
5. Select either the `rider` or `driver` run configuration and run on an emulator or device.

---

## Project Structure

Before making changes, read the architecture and modularization docs:

- [Architecture.md](docs/Architecture.md) — layered architecture, data flow, and module rules
- [Modularization.md](docs/Modularization.md) — module groups, dependency rules, and the api/impl split

Key rule: **dependencies flow inward toward core**. Feature modules depend on core modules. App modules depend on feature modules. Core modules never depend on feature or app modules.

---

## Branch Naming

| Type | Pattern | Example |
|---|---|---|
| Feature | `feature/short-description` | `feature/ride-request-screen` |
| Bug fix | `fix/short-description` | `fix/driver-location-crash` |
| Chore | `chore/short-description` | `chore/update-compose-bom` |
| Docs | `docs/short-description` | `docs/update-architecture` |

---

## Commit Messages

Follow this format:

```
type(scope): short description

Optional longer description explaining why the change was made.
```

Types: `feat`, `fix`, `chore`, `docs`, `refactor`, `test`, `style`

Examples:

```
feat(ride-booking): add fare estimate screen
fix(core-network): handle token refresh on 401
chore(deps): update Room to 2.8.4
docs(architecture): add realtime flow diagram
```

---

## Adding a New Feature Module

Each feature is split into an `api` module and an `impl` module.

**1. Create the api module** — contains only the public contract (navigation route, public models):

```
feature/rider/my-feature/
  api/
    build.gradle.kts
    src/main/AndroidManifest.xml
    src/main/kotlin/com/openrideafrica/feature/rider/myfeature/api/
```

`api/build.gradle.kts`:
```kotlin
plugins {
    alias(libs.plugins.openride.android.feature.api)
}

android {
    namespace = "com.openrideafrica.feature.rider.myfeature.api"
}
```

**2. Create the impl module** — contains screens, ViewModels, DI:

```
feature/rider/my-feature/
  impl/
    build.gradle.kts
    src/main/AndroidManifest.xml
    src/main/kotlin/com/openrideafrica/feature/rider/myfeature/impl/
```

`impl/build.gradle.kts`:
```kotlin
plugins {
    alias(libs.plugins.openride.android.feature)
}

android {
    namespace = "com.openrideafrica.feature.rider.myfeature.impl"
}

dependencies {
    implementation(project(":feature:rider:my-feature:api"))
    implementation(project(":core:data"))
}
```

**3. Register both modules** in `settings.gradle.kts`:

```kotlin
include(":feature:rider:my-feature:api")
include(":feature:rider:my-feature:impl")
```

**4. Wire the impl module** into `:rider` or `:driver` app module's `build.gradle.kts`.

---

## Code Style

- Follow [Kotlin coding conventions](https://kotlinlang.org/docs/coding-conventions.html)
- Use `internal` for everything that doesn't need to be public
- ViewModels expose `StateFlow<UiState>` — never expose mutable state
- Screens are `@Composable` functions that receive state and callbacks — no direct ViewModel access in nested composables
- Use cases are single-responsibility — one public `operator fun invoke()`
- Repositories expose `Flow` for observable data and `suspend fun` for one-shot operations

---

## Architecture Rules

These rules are enforced by the modularization structure:

```
✅ Feature impl → Feature api (own module only)
✅ Feature impl → Core modules
✅ Feature impl → Another feature's api (for navigation only)
✅ App module → Feature impl modules
✅ App module → Core modules needed for app setup

❌ Core → Feature
❌ Core → App
❌ Feature api → Feature impl
❌ Rider feature → Driver feature (and vice versa)
❌ UI → Network directly
❌ UI → Database directly
```

---

## Running Tests

```bash
# Unit tests for all modules
./gradlew test

# Unit tests for a specific module
./gradlew :core:domain:test

# Android instrumented tests
./gradlew connectedAndroidTest
```

---

## Submitting a Pull Request

1. Fork the repository and create your branch from `main`.
2. Make your changes following the code style and architecture rules above.
3. Add tests for any new business logic (use cases, repositories, ViewModels).
4. Make sure all tests pass: `./gradlew test`
5. Make sure the project builds: `./gradlew assembleDebug`
6. Open a pull request with a clear title and description explaining what changed and why.
7. Link any related issues in the PR description.

---

## Questions

Open a [GitHub Discussion](https://github.com/musyokamuasya/open-ride-android/discussions) for questions or ideas. Use [GitHub Issues](https://github.com/musyokamuasya/open-ride-android/issues) for bug reports and feature requests.