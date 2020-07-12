  
[![License](https://img.shields.io/badge/License-Apache%202.0-blue.svg)](https://opensource.org/licenses/Apache-2.0) [![](https://jitpack.io/v/arioki1/Custom-Toolbar.svg)](https://jitpack.io/#arioki1/Custom-Toolbar)  [![API](https://img.shields.io/badge/API-21%2B-blue.svg?style=flat)](https://source.android.com/setup/start/build-numbers)
# Custom-Toolbar

A simple Android library for Custom toolbar, you can modify this project to suit your needs with ease

## Screenshots

<img src="https://github.com/arioki1/Custom-Toolbar/blob/master/ss.png" width="250px" />

## Installation

Add Jitpack to your project build.gralde file
      
```Kotlin
allprojects {
   repositories {
      ...
      maven { url 'https://jitpack.io' }
   }
}
```

Then add this dependency to your app build.gradle file.

```Kotlin
dependencies {
   implementation 'https://github.com/arioki1/Custom-Toolbar:latest-release'
   Or
   implementation 'com.github.arioki1:Custom-Toolbar:1.0'
}
```

### Usage

1. Declare your `Toolbar` with `CustomToolbar`.

```xml
<?xml version="1.0" encoding="utf-8"?>
<androidx.constraintlayout.widget.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".MainActivity">
    <com.google.android.material.appbar.AppBarLayout
        android:id="@+id/toolbar"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        app:elevation="0dp"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toTopOf="parent">
        <com.arioki.customtoolbar.CustomToolbar
            android:id="@+id/customToolbar"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            app:toolbarEnableButtonLeft="true"
            app:toolbarEnableButtonRight="true"
            app:toolbarTitle="@string/custom_toolbar_main"/>
    </com.google.android.material.appbar.AppBarLayout>
</androidx.constraintlayout.widget.ConstraintLayout>
```
You can see this in action in the sample app [here](https://github.com/arioki1/Custom-Toolbar/blob/master/app/src/main/java/com/arioki/sample/MainActivity.kt#L13-L21)

## License

Copyright (c) 2020 Yoga Setiawan

   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at
         
      http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.
