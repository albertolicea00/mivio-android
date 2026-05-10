# Mivio

Mivio is a high-performance media management and playback application for Android, inspired by Infuse. It provides a seamless experience for organizing and playing local and network-stored media (SMB, WebDAV) with automatic metadata fetching and subtitle management.

## 🚀 Features

- **Multi-Source Support**: Add local storage, SMB (jcifs-ng), and WebDAV (Sardine) sources.
- **Automatic Library Scanning**: Scans for movies and TV episodes, intelligently parsing titles, years, seasons, and resolutions.
- **Rich Metadata**: Integration with **TMDB** for posters, backdrops, cast information, ratings, and synopses.
- **Subtitle Management**: Search and download subtitles directly via **OpenSubtitles**.
- **Secure Playback**: High-quality playback using **Media3 ExoPlayer** with playback progress tracking.
- **Modern UI**: Built entirely with **Jetpack Compose** and **Material 3** for a smooth, native feel.

## 🛠 Tech Stack

- **Language**: 100% Kotlin
- **UI Framework**: Jetpack Compose (Material 3)
- **Architecture**: MVVM / Clean Architecture
- **Dependency Injection**: Dagger Hilt
- **Database**: Room (SQLite)
- **Networking**: Retrofit2 + OkHttp + Gson
- **Image Loading**: Coil
- **Video Engine**: Media3 ExoPlayer
- **Async/Concurrency**: Kotlin Coroutines & Flow


## 🏗 Project Structure

- `app/`: Main application module.
- `media-scanner/`: Core logic for file scanning and parsing (Local, SMB, WebDAV).
- `network/`: API integrations (TMDB, OpenSubtitles).
- `database/`: Room entities, DAOs, and database configuration.
- `ui/`: Compose screens, components, and theme.

## ⚙️ Requirements

- **Min SDK**: 26 (Android 8.0 Oreo)
- **Target SDK**: 34 (Android 14)
- **Internet Permission**: Required for API and network sources.
- **Storage Permissions**: Required for local media access (handles Scoped Storage).

## 📥 Getting Started

1. Clone the repository:
   ```bash
   git clone https://github.com/albertolicea00/mivio-android.git
   ```
2. Open in **Android Studio (Hedgehog or newer)**.
3. Add your TMDB API Key in `local.properties`:
   ```properties
   TMDB_API_KEY=your_api_key_here
   ```
4. Build and run!

## 🤝 Contributing

Contributions are welcome! Please read our [CONTRIBUTING.md](CONTRIBUTING.md) for details on our branch strategy and coding standards.

## 📄 License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.
