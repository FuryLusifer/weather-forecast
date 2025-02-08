
# Weather Forecast App

The Weather Forecast App is a Java-based application that provides real-time weather updates using the OpenWeather API. Built with Java Swing for a rich graphical user interface (GUI) and JSON parsing for efficient data retrieval, this app allows users to check the current weather conditions for any city worldwide. The app is designed to be lightweight, easy to use, and extensible for future improvements.


## Features

- Real-Time Weather Data: Displays current weather conditions (temperature, humidity, wind speed) based on the selected city.
- Beautiful GUI: User-friendly interface built using Java Swing with visually appealing icons (cloud, rain, sun) based on weather conditions.
- Global Accessibility: Users can check weather updates for cities across the globe.
- API Integration: Powered by the OpenWeather API for accurate and reliable weather information.
- Loading Animation: Includes a loading animation (loading.gif) during data fetch from the API.

## Prerequisites

- Java Development Kit (JDK): Version 23 or higher
- Maven: A build automation tool for Java projects
- IDE (Optional): Visual Studio Code, IntelliJ IDEA, or Eclipse
## Run the application

Clone the project

```bash
git clone https://github.com/YourUsername/weather-forecast.git

```

Go to the project directory

```bash
cd weather-forecast
```

Install dependencies

```bash
mvn install
```

Run

```bash
mvn exec:java -Dexec.mainClass="com.weatherapp.weatherGUI"

```


## API Integration

The app uses the OpenWeather API to fetch weather data. The API key is required for the app to function.

- API Key: *******************
- API URL: https://api.openweathermap.org/data/2.5/weather?q={city name},{country code}&appid={API key}
You can replace the API key in the weatherService.java file if necessary.
## Contributing

We welcome contributions! If you'd like to improve the Weather Forecast App, feel free to fork the repository, create a branch for your feature or bugfix, and submit a pull request.

    1. Fork the repository.
    2. Create a new branch (git checkout -b feature/your-feature-name).
    3. Make your changes and commit (git commit -am 'Add feature/bugfix').
    4. Push to your branch (git push origin feature/your-feature-name).
    5. Submit a pull request.


## 🔗 Links
[![linkedin](https://img.shields.io/badge/linkedin-0A66C2?style=for-the-badge&logo=linkedin&logoColor=white)](https://www.linkedin.com/in/piyushkayastha)
[![Instagram](https://img.shields.io/badge/Instagram-E4405F?style=for-the-badge&logo=instagram&logoColor=white)](https://www.instagram.com/piyushkayastha2/)

Thank you for using Weather Forecast App!
Stay updated with real-time weather anywhere, anytime!

