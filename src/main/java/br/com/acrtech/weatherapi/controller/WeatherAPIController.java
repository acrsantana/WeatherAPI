package br.com.acrtech.weatherapi.controller;

import br.com.acrtech.weatherapi.service.WeatherAPIService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("weather")
public class WeatherAPIController {

    private final WeatherAPIService service;

    public WeatherAPIController(WeatherAPIService service) {
        this.service = service;
    }

    @GetMapping("/{city}")
    public String getWeather(@PathVariable("city") String city) {
        return service.getWeather(city);
    }

}
