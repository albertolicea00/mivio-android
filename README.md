# 🍿 Mivio for Android

[![Kotlin](https://img.shields.io/badge/Kotlin-100%25-purple.svg?style=flat-square&logo=kotlin)](https://kotlinlang.org/)
[![Jetpack Compose](https://img.shields.io/badge/UI-Jetpack_Compose-blue.svg?style=flat-square)](https://developer.android.com/jetpack/compose)
[![Room](https://img.shields.io/badge/Database-Room_SQLite-red.svg?style=flat-square)](https://developer.android.com/training/data-storage/room)
[![Platform Compatibility](https://img.shields.io/badge/Platforms-Android%20Mobile%20%7C%20Tablets-brightgreen.svg?style=flat-square)](#platform-specific-goals)
[![License: Non-Commercial](https://img.shields.io/badge/License-Non_Commercial-red.svg?style=flat-square)](LICENSE)

**Mivio** is a premium, high-performance media management and playback application meticulously designed for the Android Ecosystem. Built natively using modern Kotlin, Jetpack Compose, and Room, Mivio delivers an elegant, fast, and native media cataloging and streaming experience across **Android smartphones and tablets**.

Whether scanning local folders on internal storage, connecting to high-speed home network shares via **SMB**, or streaming over a secure cloud-based **WebDAV** server, Mivio handles metadata collection, naming parsing, watch progress tracking, and media playback seamlessly.

---

## 🎨 Platform Features & Limitations

Mivio for Android is the most complete implementation regarding local playback and networking, adapting its interface and capabilities to the device:

### 📺 Android TV / Google TV
- ✅ **USB Read & Write**: Full support for external drives. You can even write and save `.nfo` metadata files and artwork locally.
- ✅ **Home Server Client**: Fully connects to Plex, Jellyfin, and Emby.
- ✅ **Optional Local Multi-Account**: Manage different local profiles on the TV itself.
- ✅ **Advanced Player**: Integrated high-performance playback utilizing **Media3 ExoPlayer** and **VLC** engines.

### 📱 Android Mobile & Tablet
- ✅ **Local + Servers**: Identical to iOS, supporting both local device storage and external server connections.
- ✅ **Local Multi-Account**: Each user saves their progress independently on the same device.
- ✅ **Dynamic UI**: Responsive grids, fluid swipe gestures, and native Picture-in-Picture (PiP).

---

## 📂 Project Directory Structure

The project is designed with a Clean Architecture / MVVM approach to keep the core and user-interface modular, clean, and testable:

```text
mivio-android/
├── app/                      # Main application module
├── media-scanner/            # Core logic for file scanning and parsing (Local, SMB, WebDAV)
├── network/                  # API integrations (TMDB, OpenSubtitles)
├── database/                 # Room entities, DAOs, and database configuration
└── ui/                       # Compose screens, components, and Material 3 theme
```

---

## 🛠️ Key Components & Technologies

- **Language**: 100% Kotlin
- **UI Framework**: Jetpack Compose (Material 3)
- **Dependency Injection**: Dagger Hilt
- **Database (ORM)**: Room (SQLite)
- **Networking**: Retrofit2 + OkHttp + Gson
- **Image Loading**: Coil
- **Video Player**: Media3 ExoPlayer
- **Async / Concurrency**: Kotlin Coroutines & Flow

---

## 🚀 Getting Started

### Prerequisites
- **Android Studio** (Hedgehog or newer).
- Minimum SDK: **26** (Android 8.0 Oreo).
- Target SDK: **34** (Android 14).

### Setup and Running the Project
1. **Clone the Repository:**
   ```bash
   git clone https://github.com/albertolicea00/mivio-android.git
   cd mivio-android
   ```

2. **Open in Android Studio:**
   Launch Android Studio and open the `mivio-android` directory.

3. **Configure API Keys:**
   Add your TMDB API Key in `local.properties`:
   ```properties
   TMDB_API_KEY=your_api_key_here
   ```

4. **Build and Run:**
   Select your physical device or emulator and press **Run** (`Shift + F10`).

---

## 🤝 Contribution Guidelines

We use a structured branch strategy to protect stable builds while supporting active feature implementation:
- **`main`**: Production-ready release branch.
- **`beta`**: Standard development target. **Always target your PRs to `beta`!**

For detailed instructions on commit formats, coding style guidelines, and PR checks, please review [CONTRIBUTING.md](CONTRIBUTING.md).

For vulnerability reporting or security-related matters, see [SECURITY.md](SECURITY.md).

---

## 📄 License
This project is licensed under the **Mivio Source-Available End User License Agreement (EULA)**. Commercial use, monetization, and unauthorized redistribution are strictly prohibited. See the [LICENSE](LICENSE) file for details.
