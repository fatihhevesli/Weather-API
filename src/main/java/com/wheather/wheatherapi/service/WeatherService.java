package com.wheather.wheatherapi.service;

import com.wheather.wheatherapi.model.DailyWeatherResponse;
import com.wheather.wheatherapi.model.WeatherResponse;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class WeatherService {

    private final RestTemplate restTemplate;
    private final String apiKey = "5bd5d09fd9614eac859181145232702";

    public WeatherService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public WeatherResponse getWeatherByCityName(String cityName) {
        String url = "https://api.openweathermap.org/data/2.5/weather?q=" + cityName + "&appid=" + apiKey;
        return restTemplate.getForObject(url, WeatherResponse.class);
    }

    public WeatherResponse getWeatherByCountryName(String countryName) {
        String url = "https://api.openweathermap.org/data/2.5/weather?q=" + countryName + "&appid=" + apiKey;
        return restTemplate.getForObject(url, WeatherResponse.class);
    }
    public WeatherResponse getWeather(String cityName, String countryCode) {
        String url = String.format("%s/current.json?key=%s&q=%s,%s&aqi=no", baseUrl, apiKey, cityName, countryCode);
        return restTemplate.getForObject(url, WeatherResponse.class);
    }

    public DailyWeatherResponse getDailyWeather(String cityName, String countryCode, int days) {
        String url = String.format("%s/forecast.json?key=%s&q=%s,%s&days=%d&aqi=no&alerts=no", baseUrl, apiKey, cityName, countryCode, days);
        return restTemplate.getForObject(url, DailyWeatherResponse.class);
    }

    public WeeklyWeatherResponse getWeeklyWeather(String cityName, String countryCode) {
        String url = String.format("%s/forecast.json?key=%s&q=%s,%s&days=7&aqi=no&alerts=no", baseUrl, apiKey, cityName, countryCode);
        return restTemplate.getForObject(url, WeeklyWeatherResponse.class);
    }

    public MonthlyWeatherResponse getMonthlyWeather(String cityName, String countryCode) {
        String url = String.format("%s/forecast.json?key=%s&q=%s,%s&month=3&aqi=no&alerts=no", baseUrl, apiKey, cityName, countryCode);
        return restTemplate.getForObject(url, MonthlyWeatherResponse.class);
    }


}
