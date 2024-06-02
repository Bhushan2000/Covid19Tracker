# COVID-19 Tracker

An Android application to track the latest COVID-19 statistics. This app provides real-time data on COVID-19 cases, recoveries, and deaths from around the world.

## Features

- **Real-Time Data**: Get the latest COVID-19 statistics.
- **Global and Country-Specific Data**: View data for the entire world or specific countries.
- **Graphical Representations**: Visualize data with charts and graphs.
- **Search Functionality**: Search for specific countries to get detailed data.
- **Data Refresh**: Pull-to-refresh to get the latest data updates.

## Screenshots

![Global Stats](screenshots/global_stats.png)
![Country Stats](screenshots/country_stats.png)
![Search Country](screenshots/search_country.png)

## Getting Started

Follow these instructions to get a copy of the project up and running on your local machine.

### Prerequisites

- Android Studio
- Android SDK
- Gradle

### Installation

1. **Clone the repository:**
    ```sh
    git clone https://github.com/Bhushan2000/Covid19Tracker.git
    ```

2. **Open the project in Android Studio:**
    - Open Android Studio.
    - Select `Open an existing Android Studio project`.
    - Navigate to the cloned repository and open it.

3. **Build the project:**
    - Click on the `Build` menu and select `Make Project`.

4. **Run the app:**
    - Connect an Android device or start an emulator.
    - Click on the `Run` button or press `Shift + F10`.

## Usage

1. **View Global Statistics:**
    - The home screen displays global COVID-19 statistics including total cases, recoveries, and deaths.

2. **View Country-Specific Statistics:**
    - Tap on a country from the list to view detailed statistics for that country.

3. **Search for a Country:**
    - Use the search bar to find and select a specific country.

4. **Refresh Data:**
    - Pull down on the statistics screen to refresh and get the latest data.

## Built With

- [Kotlin](https://kotlinlang.org/) - Programming language used
- [Jetpack Compose](https://developer.android.com/jetpack/compose) - Modern toolkit for building native UI
- [Retrofit](https://square.github.io/retrofit/) - HTTP client for API requests
- [Hilt](https://developer.android.com/training/dependency-injection/hilt-android) - Dependency injection library
- [MPAndroidChart](https://github.com/PhilJay/MPAndroidChart) - Chart library for Android

## Contributing

Contributions are welcome! Please follow these steps:

1. Fork the repository.
2. Create a new branch (`git checkout -b feature/your-feature`).
3. Commit your changes (`git commit -m 'Add some feature'`).
4. Push to the branch (`git push origin feature/your-feature`).
5. Open a Pull Request.

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

## Acknowledgments

- Data sourced from public APIs.
- Inspiration from various COVID-19 tracking applications and dashboards.

---

Stay safe and healthy!
