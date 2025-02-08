Weather Forecast App
Overview
The Weather Forecast App is a Java-based application that provides real-time weather updates using the OpenWeather API. Built with Java Swing for a rich graphical user interface (GUI) and JSON parsing for efficient data retrieval, this app allows users to check the current weather conditions for any city worldwide. The app is designed to be lightweight, easy to use, and extensible for future improvements.

Features
Real-Time Weather Data: Displays current weather conditions (temperature, humidity, wind speed) based on the selected city.
Beautiful GUI: User-friendly interface built using Java Swing with visually appealing icons (cloud, rain, sun) based on weather conditions.
Global Accessibility: Users can check weather updates for cities across the globe.
API Integration: Powered by the OpenWeather API for accurate and reliable weather information.
Loading Animation: Includes a loading animation (loading.gif) during data fetch from the API.
Screenshots

Sample screenshot of the Weather Forecast App showing weather conditions.

Prerequisites
Java Development Kit (JDK): Version 23 or higher
Maven: A build automation tool for Java projects
IDE (Optional): Visual Studio Code, IntelliJ IDEA, or Eclipse
Installation
Clone the Repository
To get started, clone the repository to your local machine using Git:

bash
Copy
Edit
git clone https://github.com/YourUsername/weather-forecast.git
cd weather-forecast
Set Up the Project
Ensure that JDK 23 and Maven are installed on your system.
Open the project folder in your preferred IDE or use a text editor like VS Code.
Open the terminal and run the following command to download dependencies:
bash
Copy
Edit
mvn install
Once all dependencies are installed, you're ready to run the project.
Running the Application
To run the Weather Forecast App, use the following Maven command:

bash
Copy
Edit
mvn exec:java -Dexec.mainClass="com.weatherapp.weatherGUI"
This command will launch the Swing GUI, allowing you to input a city name and retrieve real-time weather data.

API Integration
The app uses the OpenWeather API to fetch weather data. The API key is required for the app to function.

API Key: 0792b103f3dbd166e6f43a5d5c01ae74
API URL: https://api.openweathermap.org/data/2.5/weather?q={city name},{country code}&appid={API key}
You can replace the API key in the weatherService.java file if necessary.

Directory Structure
The project is organized as follows:

bash
Copy
Edit
weather-forecast/
├── src/
│   ├── com/
│   │   ├── weatherapp/
│   │   │   ├── WeatherApp.java          # Main class for running the app
│   │   │   ├── WeatherGUI.java          # GUI interface built with Java Swing
│   │   │   ├── WeatherData.java         # Data model for storing weather info
│   │   │   ├── WeatherService.java      # Service class for API integration
│   ├── resources/
│   │   ├── assets/
│   │   │   ├── cloud.svg                # Icon for cloudy weather
│   │   │   ├── rain.svg                 # Icon for rainy weather
│   │   │   ├── sun.svg                  # Icon for sunny weather
│   │   │   ├── loading.gif              # Loading animation
├── pom.xml                              # Maven project configuration file
├── .gitignore                           # Git ignore file
├── README.md                            # Project documentation
Contributing
We welcome contributions! If you'd like to improve the Weather Forecast App, feel free to fork the repository, create a branch for your feature or bugfix, and submit a pull request.

Fork the repository.
Create a new branch (git checkout -b feature/your-feature-name).
Make your changes and commit (git commit -am 'Add feature/bugfix').
Push to your branch (git push origin feature/your-feature-name).
Submit a pull request.
License
This project is licensed under the MIT License - see the LICENSE file for details.

Contact
For any questions or feedback, please reach out to me via GitHub or email.

