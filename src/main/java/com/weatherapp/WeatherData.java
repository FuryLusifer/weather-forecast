package com.weatherapp;

/**
 * Model class representing weather data.
 */
public class WeatherData {
    private String cityName;
    private String countryCode;
    private String weatherDescription;
    private double temperature;
    private String iconFile; // Local icon file name (e.g., "sun.svg", "rain.svg", "cloud.svg")

    /**
     * Constructs a WeatherData object with the specified parameters.
     *
     * @param cityName the name of the city
     * @param countryCode the country code
     * @param weatherDescription description of the weather condition
     * @param temperature current temperature in Celsius
     * @param iconFile the local icon file name representing the weather condition
     */
    public WeatherData(String cityName, String countryCode, String weatherDescription, double temperature, String iconFile) {
        this.cityName = cityName;
        this.countryCode = countryCode;
        this.weatherDescription = weatherDescription;
        this.temperature = temperature;
        this.iconFile = iconFile;
    }

    // Getters
    public String getCityName() {
        return cityName;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public String getWeatherDescription() {
        return weatherDescription;
    }

    public double getTemperature() {
        return temperature;
    }

    public String getIconFile() {
        return iconFile;
    }

    @Override
    public String toString() {
        return "WeatherData [city=" + cityName + ", country=" + countryCode +
                ", description=" + weatherDescription + ", temperature=" + temperature + "°C, icon=" + iconFile + "]";
    }
}
