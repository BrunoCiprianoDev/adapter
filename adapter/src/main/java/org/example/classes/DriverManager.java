package org.example.classes;

public class DriverManager {

    private double temperature;
    private String clock; // HH:mm
    private String date; // MM-dd-yyyy

    public DriverManager(double temperature, String clock, String date) {
        this.temperature = temperature;
        this.clock = clock;
        this.date = date;
    }

    public double getTemperature() {
        return temperature;
    }

    public String getClock() {
        return clock;
    }

    public String getDate() {
        return date;
    }
}
