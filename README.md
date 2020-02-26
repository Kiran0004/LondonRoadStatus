# LondonRoadStatus

Using this project we can get the status of given Road from Tfl API.Once we enter Road Name we can get the result status like below.

In this project we can see the name,severity and severity description of the given road. For non-valid roads appropriate error message shown in the screen.

It will be done using Clean Architecture,Modularization and followed MVVM architecture pattern.


## Libraries and Tools Used

- Kotlin
- MVVM Architecute
 - App Compat
 - Material Components
- Android Architecture Components
    - Databinding and ViewModel
- Retrofit
- Kotlin Coroutines
- Koin - dependency injection
- Mockito,JUnit,Espresso (Unit testing)

More details of android jetpack components listed below.

https://developer.android.com/jetpack/docs/guide

## Project Structure

This project is built using Clean Architecture and it has modules in the following way:

**app** - contains Activities/Fragments and their Adapters for the presentation layer

**data** - contains API details and netowrk handling

**domain** - contains implementation details for network(Retrofit/Room/SQLDelight/Realm)


## LondonRoadStatus Code checkout process

Steps to run the project using the command line:

Get the project locally:

git clone https://github.com/Kiran0004/LondonRoadStatus.git

Navigate to the /app folder and execute assemblDebug command from Gradle Wrapper:

./gradlew assembleDebug After the build, app-debug.apk can be found inside your project dir using this path app/build/outputs/apk/debug/

Using adb install project directly to a device or emulator using the command below:

adb install app/build/outputs/apk/debug/app-debug.apk

You can also use Android Studio for that purpose either: VSC -> Git -> Clone Insert URL https://github.com/Kiran0004/LondonRoadStatus.git

You can replace API keys from data_build.gradle with your own keys.


## TFL API

The API key and APP_Id should be in a **data_build.gradle** file

TfL maintains an open data REST API at https://api.tfl.gov.uk

In order to use it you will need to register for a developer key here: https://api-portal.tfl.gov.uk/



