package com.weatherapp;

import javax.swing.SwingUtilities;

/**
 * Main entry point for the Weather Forecast Application.
 */
public class WeatherApp {
    public static void main(String[] args) {
        // Launch the GUI on the Event Dispatch Thread
        SwingUtilities.invokeLater(() -> new WeatherGUI());
    }
}
