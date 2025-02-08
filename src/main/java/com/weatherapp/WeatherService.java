package com.weatherapp;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

/**
 * Service class responsible for fetching weather data from the OpenWeather API.
 */
public class WeatherService {
    // API key and URL for OpenWeather
    private static final String API_KEY = "0792b103f3dbd166e6f43a5d5c01ae74";
    // API URL with placeholders for city name, country code, and API key; units set to metric (Celsius)
    private static final String API_URL = "https://api.openweathermap.org/data/2.5/weather?q=%s,%s&appid=%s&units=metric";

    /**
     * Fetches weather data for the specified city and country code.
     *
     * @param cityName the city name
     * @param countryCode the country code (e.g., "GB")
     * @return a WeatherData object containing the fetched data
     * @throws Exception if an error occurs during the API call or parsing
     */
    public static WeatherData getWeatherData(String cityName, String countryCode) throws Exception {
        // Build the full URL string using the provided city, country, and API key
        String urlString = String.format(API_URL, cityName, countryCode, API_KEY);
        // Create a URI from the URL string (avoiding deprecated URL constructors)
        URI uri = URI.create(urlString);

        // Create an HTTP client
        HttpClient client = HttpClient.newHttpClient();
        // Build an HTTP GET request
        HttpRequest request = HttpRequest.newBuilder()
                .uri(uri)
                .header("Accept", "application/json")
                .GET()
                .build();

        // Send the request and capture the response
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        // Parse the JSON response
        JsonObject jsonResponse = JsonParser.parseString(response.body()).getAsJsonObject();

        // Extract weather description and temperature from the JSON
        String description = jsonResponse.getAsJsonArray("weather")
                .get(0).getAsJsonObject()
                .get("description").getAsString();
        double temperature = jsonResponse.getAsJsonObject("main")
                .get("temp").getAsDouble();

        // Determine the appropriate icon file based on the weather description
        String iconFile = mapWeatherToIcon(description);

        // Return a new WeatherData object populated with the extracted data
        return new WeatherData(cityName, countryCode, description, temperature, iconFile);
    }

    /**
     * Maps the weather description to a local icon file name.
     *
     * @param description the weather description text
     * @return the icon file name (e.g., "sun.svg", "rain.svg", "cloud.svg")
     */
    private static String mapWeatherToIcon(String description) {
        description = description.toLowerCase();
        if (description.contains("rain")) {
            return "rain.svg";
        } else if (description.contains("cloud")) {
            return "cloud.svg";
        } else if (description.contains("clear")) {
            return "sun.svg";
        }
        // Default icon if no specific condition is met
        return "sun.svg";
    }
}
