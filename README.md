# UIComponentsLibrary

...

## 📦 Installation

### Step 1: Add JitPack Repository

In your `settings.gradle.kts`, add the JitPack repository inside dependencyResolutionManagement:

```kotlin
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        mavenCentral()
        maven { url = uri("https://jitpack.io") }
    }
}
```

### Step 2: Add the Library Dependency

In your module-level build.gradle.kts:

```kotlin
dependencies {
    implementation("com.github.PaponAhasan:UIComponentsLibrary:Tag")
}
```

## 🏷️ Latest Version

You can find the latest version here on JitPack. [Check Latest](https://jitpack.io/#PaponAhasan/UIComponentsLibrary)

📌 Note: Replace Tag with the latest release tag of the library

## 🚀 Features

- ✅ Supports both XML and Jetpack Compose

- 🎨 Highly customizable UI components

- ⚡ Lightweight and optimized for performance

- 🧩 Easy to integrate into any Android project

- 🛠️ Built following SOLID principles for clean architecture

- 📱 Responsive and modern design

## 🛠️ Usage

### XML View Example

```kotlin
<com.rakibul.ahasan.uicomponents.CircularLoadingView
    android:layout_width="100dp"
    android:layout_height="100dp"
    android:layout_gravity="center"/>
```

### Jetpack Compose Example

```
CircularLoadingCompose(
    modifier = Modifier.size(100.dp),
    color = Color.Gray
)
```

## 🛡️ License

```
MIT License
```
This project is licensed under the terms of the MIT license.

## 🤝 Contributing

- Contributions are very welcome! 🎉
- If you want to contribute:
- Fork the repository
- Create a new feature branch
- Make your changes
- Submit a Pull Request
- We appreciate your support

## 📬 Contact
- Author: Rakibul Ahasan
- Email: ahasan.papon@gmail.com
- GitHub: @PaponAhasan
