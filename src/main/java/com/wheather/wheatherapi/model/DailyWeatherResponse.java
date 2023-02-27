package com.wheather.wheatherapi.model;

import lombok.Data;

import java.util.List;
@Data
public class DailyWeatherResponse {

    private Location location;
    private List<ForecastDay> forecastDays;

    // getters and setters

    public static class Location {
        private String name;
        private String region;
        private String country;
        private float lat;
        private float lon;
        private String tzId;
        private String localtime;

        // getters and setters
    }

    public static class ForecastDay {
        private String date;
        private Day day;
        private Astro astro;

        // getters and setters
    }

    public static class Day {
        private float maxtemp_c;
        private float mintemp_c;
        private float avgtemp_c;
        private float maxwind_kph;
        private float totalprecip_mm;
        private float avgvis_km;
        private float avghumidity;

        // getters and setters
    }

    public static class Astro {
        private String sunrise;
        private String sunset;
        private String moonrise;
        private String moonset;

        // getters and setters
    }
}
