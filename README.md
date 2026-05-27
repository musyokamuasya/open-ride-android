# OpenRide Africa

An open-source ride-hailing platform for Africa, built with Modern Android Development best practices.

OpenRide Africa is a two-app Android platform — a **Rider app** and a **Driver app** — built on a shared foundation of core modules and feature modules.

---

## Screenshots

> Coming soon

---

## Tech Stack

| Layer | Technology |
|---|---|
| Language | Kotlin |
| UI | Jetpack Compose |
| Architecture | MVVM + Clean Architecture |
| DI | Hilt |
| Navigation | Navigation Compose |
| Networking | Retrofit + OkHttp + kotlinx.serialization |
| Local DB | Room |
| Preferences | DataStore |
| Async | Kotlin Coroutines + Flow |
| Realtime | WebSockets via OkHttp |
| Build | Convention Plugins + Version Catalogs |

---

## Architecture

OpenRide follows a layered architecture:

```
UI Layer → Domain Layer → Data Layer
```

- **UI layer** — Compose screens, ViewModels, UI state
- **Domain layer** — Use cases with focused business logic
- **Data layer** — Repositories coordinating network, database, and realtime sources

See [Architecture.md](docs/Architecture.md) for the full architecture documentation.

---

## Modularization

The project is a single Gradle monorepo with two app modules and shared infrastructure:

```
:rider                          — Rider app
:driver                         — Driver app

:core:model                     — Pure Kotlin domain models
:core:common                    — Shared utilities
:core:designsystem              — Design tokens, themes, components
:core:ui                        — Shared UI building blocks
:core:domain                    — Use cases
:core:data                      — Repositories
:core:network                   — Retrofit + OkHttp
:core:database                  — Room
:core:datastore                 — DataStore preferences
:core:realtime                  — WebSocket layer
:core:location                  — Location abstraction
:core:maps                      — Maps abstraction
:core:notifications             — Push notifications
:core:sync                      — Background sync with WorkManager
:core:analytics                 — Analytics abstraction
:core:testing                   — Test fakes and utilities

:feature:rider:*:api            — Rider feature public contracts
:feature:rider:*:impl           — Rider feature implementations
:feature:driver:*:api           — Driver feature public contracts
:feature:driver:*:impl          — Driver feature implementations
:feature:shared:*:api           — Shared feature public contracts
:feature:shared:*:impl          — Shared feature implementations
```

See [Modularization.md](docs/Modularization.md) for the full modularization documentation.

---

## Requirements

- Android Studio Meerkat or newer
- JDK 17
- Android SDK 36
- Minimum Android 8.0 (API 26)

---

## Building and Running

1. Clone the repository:

```bash
git clone https://github.com/musyokamuasya/open-ride-android.git
cd open-ride-android
```

2. Open the project in Android Studio.

3. Select a run configuration:
    - **rider** — builds and runs the Rider app
    - **driver** — builds and runs the Driver app

4. Run on an emulator or physical device.

To build from the command line:

```bash
# Rider app debug build
./gradlew :rider:assembleDebug

# Driver app debug build
./gradlew :driver:assembleDebug
```

---

## Convention Plugins

This project uses Gradle convention plugins in `build-logic/` to share build configuration across all modules. Each module type has a corresponding plugin:

| Plugin | Used by |
|---|---|
| `openride.android.application` | `:rider`, `:driver` |
| `openride.android.application.compose` | `:rider`, `:driver` |
| `openride.android.library` | All `:core:*` modules |
| `openride.android.library.compose` | `:core:designsystem`, `:core:ui` |
| `openride.android.feature` | All `:feature:*:*:impl` modules |
| `openride.android.feature.api` | All `:feature:*:*:api` modules |
| `openride.hilt` | Any module using DI |
| `openride.android.room` | `:core:database` |
| `openride.kotlin.library` | `:core:model` |
| `openride.kotlin.serialization` | `:core:network` and others |

---

## Project Structure

```
open-ride-android/
  build-logic/          — Convention plugins
  core/                 — Shared infrastructure modules
  driver/               — Driver app module
  docs/                 — Architecture and modularization docs
  feature/              — Feature modules
    driver/             — Driver-specific features
    rider/              — Rider-specific features
    shared/             — Shared features (auth, profile, etc.)
  gradle/               — Version catalog (libs.versions.toml)
  rider/                — Rider app module
```

---

## License

```
Copyright 2024 OpenRide Africa

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    https://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```