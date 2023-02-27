package com.wheather.wheatherapi.controller;


import com.wheather.wheatherapi.model.WeatherResponse;
import com.wheather.wheatherapi.service.WeatherService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Data
@CrossOrigin(origins = "*")
@RequiredArgsConstructor
@RequestMapping("/api")
@RestController
@RequestMapping("/weather")
public class WeatherController {

    private final WeatherService weatherService;

    public WeatherController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @GetMapping("/{cityName}")
    public ResponseEntity<WeatherResponse> getWeather(@PathVariable String cityName,
                                                      @RequestParam(required = false, defaultValue = "") String countryCode) {
        try {
            WeatherResponse weatherResponse = weatherService.getWeather(cityName, countryCode);
            return ResponseEntity.ok(weatherResponse);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/{cityName}/daily")
    public ResponseEntity<Object> getDailyWeather(@PathVariable String cityName,
                                                  @RequestParam(required = false, defaultValue = "") String countryCode,
                                                  @RequestParam(required = false, defaultValue = "7") int days) {
        try {
            DailyWeatherResponse dailyWeatherResponse = weatherService.getDailyWeather(cityName, countryCode, days);
            return ResponseEntity.ok(dailyWeatherResponse);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/{cityName}/weekly")
    public ResponseEntity<WeeklyWeatherResponse> getWeeklyWeather(@PathVariable String cityName,
                                                                  @RequestParam(required = false, defaultValue = "") String countryCode) {
        try {
            WeeklyWeatherResponse weeklyWeatherResponse = weatherService.getWeeklyWeather(cityName, countryCode);
            return ResponseEntity.ok(weeklyWeatherResponse);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/{cityName}/monthly")
    public ResponseEntity<Object> getMonthlyWeather(@PathVariable String cityName,
                                                    @RequestParam(required = false, defaultValue = "") String countryCode) {
        try {
            MonthlyWeatherResponse monthlyWeatherResponse = weatherService.getMonthlyWeather(cityName, countryCode);
            return ResponseEntity.ok(monthlyWeatherResponse);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

}

