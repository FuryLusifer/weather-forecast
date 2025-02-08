package com.weatherapp;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

/**
 * GUI class responsible for displaying weather information.
 * Implements the View component of the MVC architecture.
 */
public class WeatherGUI {
    private JFrame frame;
    private JTextField cityInput;
    private JTextField countryInput;
    private JButton fetchButton;
    private JTextArea resultArea;
    private JLabel weatherIconLabel;
    private JLabel spinnerLabel;

    /**
     * Constructs the WeatherGUI and initializes the user interface.
     */
    public WeatherGUI() {
        // Set up the main frame
        frame = new JFrame("Weather Forecast App");
        frame.setSize(600, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        frame.getContentPane().setBackground(new Color(173, 216, 230)); // Light Blue background

        // Create a top panel for user inputs and the fetch button
        JPanel topPanel = new JPanel();
        topPanel.setBackground(new Color(135, 206, 235)); // Sky Blue
        JLabel cityLabel = new JLabel("City:");
        cityInput = new JTextField(15);
        JLabel countryLabel = new JLabel("Country Code:");
        countryInput = new JTextField(5);
        fetchButton = new JButton("Get Weather");

        // Style the input fields and button
        cityInput.setFont(new Font("Arial", Font.PLAIN, 16));
        countryInput.setFont(new Font("Arial", Font.PLAIN, 16));
        fetchButton.setFont(new Font("Arial", Font.BOLD, 14));
        fetchButton.setBackground(new Color(30, 144, 255)); // Dodger Blue
        fetchButton.setForeground(Color.WHITE);
        fetchButton.setFocusPainted(false);
        fetchButton.setToolTipText("Click to fetch weather details");

        // Add components to the top panel
        topPanel.add(cityLabel);
        topPanel.add(cityInput);
        topPanel.add(countryLabel);
        topPanel.add(countryInput);
        topPanel.add(fetchButton);

        // Create a text area to display weather information
        resultArea = new JTextArea();
        resultArea.setEditable(false);
        resultArea.setFont(new Font("Arial", Font.PLAIN, 16));
        resultArea.setBackground(new Color(240, 255, 255)); // Light Cyan
        resultArea.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // Label for displaying the weather icon
        weatherIconLabel = new JLabel();
        weatherIconLabel.setHorizontalAlignment(JLabel.CENTER);

        // Add the panels and components to the frame
        frame.add(topPanel, BorderLayout.NORTH);
        frame.add(new JScrollPane(resultArea), BorderLayout.CENTER);
        frame.add(weatherIconLabel, BorderLayout.SOUTH);

        // Display the window
        frame.setVisible(true);

        // Attach an action listener to the fetch button
        fetchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String city = cityInput.getText().trim();
                String country = countryInput.getText().trim().toUpperCase();
                if (city.isEmpty() || country.isEmpty()) {
                    JOptionPane.showMessageDialog(frame,
                            "Please enter both city name and country code.",
                            "Input Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                fetchWeatherData(city, country);
            }
        });
    }

    /**
     * Initiates the process of fetching weather data using a background thread.
     *
     * @param city    the city name
     * @param country the country code
     */
    private void fetchWeatherData(String city, String country) {
        showLoadingSpinner();

        // Use SwingWorker to perform the API call without freezing the UI
        SwingWorker<WeatherData, Void> worker = new SwingWorker<>() {
            @Override
            protected WeatherData doInBackground() throws Exception {
                // Fetch weather data via the service (controller)
                return WeatherService.getWeatherData(city, country);
            }

            @Override
            protected void done() {
                try {
                    WeatherData data = get();
                    // Display weather details in the text area
                    resultArea.setText("City: " + data.getCityName() + ", " + data.getCountryCode() +
                            "\nWeather: " + data.getWeatherDescription() +
                            "\nTemperature: " + data.getTemperature() + "°C");
                    // Set the appropriate weather icon
                    setWeatherIcon(data.getIconFile());
                } catch (Exception ex) {
                    ex.printStackTrace();
                    resultArea.setText("Error fetching weather data.");
                } finally {
                    hideLoadingSpinner();
                }
            }
        };

        worker.execute();
    }

    /**
     * Displays a loading spinner while weather data is being fetched.
     */
    private void showLoadingSpinner() {
        spinnerLabel = new JLabel(new ImageIcon(getClass().getResource("/icons/loading.gif")));
        spinnerLabel.setHorizontalAlignment(JLabel.CENTER);
        // Add the spinner to the frame (using EAST region for visibility)
        frame.add(spinnerLabel, BorderLayout.EAST);
        frame.revalidate();
        frame.repaint();
    }

    /**
     * Hides the loading spinner.
     */
    private void hideLoadingSpinner() {
        if (spinnerLabel != null) {
            frame.remove(spinnerLabel);
            frame.revalidate();
            frame.repaint();
        }
    }

    /**
     * Sets the weather icon based on the provided file name.
     *
     * @param iconFile the local icon file name (e.g., "sun.svg", "rain.svg", "cloud.svg")
     */
    private void setWeatherIcon(String iconFile) {
        try {
            URL iconURL = getClass().getResource("/icons/" + iconFile);
            if (iconURL != null) {
                ImageIcon icon = new ImageIcon(iconURL);
                // Optionally, resize the icon for better display
                Image img = icon.getImage();
                Image resizedImg = img.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
                weatherIconLabel.setIcon(new ImageIcon(resizedImg));
            } else {
                weatherIconLabel.setIcon(null);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
