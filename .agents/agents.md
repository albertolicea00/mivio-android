# Mivio Android Agents Configuration

## Project Overview
Mivio for Android is a premium, high-performance media management and playback application built natively for the Android ecosystem using Kotlin, Jetpack Compose, and Room database.

## Key Technologies
- Language: 100% Kotlin
- UI Framework: Jetpack Compose (Material 3)
- Dependency Injection: Dagger Hilt
- Database (ORM): Room (SQLite)
- Networking: Retrofit2 + OkHttp + Gson
- Image Loading: Coil
- Video Player: Media3 ExoPlayer
- Async / Concurrency: Kotlin Coroutines & Flow

## Project Structure
```
mivio-android/
├── app/                      # Main application module
├── media-scanner/            # Core logic for file scanning and parsing (Local, SMB, WebDAV)
├── network/                  # API integrations (TMDB, OpenSubtitles)
├── database/                 # Room entities, DAOs, and database configuration
└── ui/                       # Compose screens, components, and Material 3 theme
```

## Development Guidelines
- Target branch for PRs: `beta` (main is production-ready)
- Follow commit conventions outlined in CONTRIBUTING.md
- Minimum SDK: 26 (Android 8.0 Oreo)
- Target SDK: 34 (Android 14)

## Agent Instructions
When working on this project:
1. Respect the Clean Architecture / MVVM approach
2. Use Kotlin idioms and best practices
3. Follow Jetpack Compose guidelines for UI development
4. Ensure proper error handling and edge case management
5. Write tests for business logic when modifying core components
6. Update documentation when changing public APIs or significant functionality