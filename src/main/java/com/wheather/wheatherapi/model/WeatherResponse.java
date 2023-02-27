package com.wheather.wheatherapi.model;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class WeatherResponse {
    private String cityName;
    private String countryName;
    private LocalDateTime dateTime;
    private double temperature;
    private double feelsLike;
    private double pressure;
    private double humidity;

}


    