package br.com.acrtech.weatherapi.service;

import br.com.acrtech.weatherapi.config.PropertiesConfig;
import br.com.acrtech.weatherapi.domain.Root;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Log4j2
public class WeatherAPIService {
    private final RestTemplate httpClient;
    private final PropertiesConfig config;

    public WeatherAPIService(RestTemplate restTemplate, PropertiesConfig config) {
        this.httpClient = restTemplate;
        this.config = config;
    }

    public String getWeather(String city){
        String url = config.getUrl() + "?q=" + city;
        log.info("URL: {}", url);
        HttpHeaders headers = new HttpHeaders();
        headers.add("X-RapidAPI-Key", config.getKey());
        headers.add("X-RapidAPI-Host", config.getHost());
        ResponseEntity<Root> entity = httpClient.exchange(url, HttpMethod.GET, new HttpEntity<>(headers), Root.class);
        Root climate = entity.getBody();
        String response = String.format("The weather in %s, %s is %s. The temperature is %s celsius, %s farenheith.\n" +
                        "It's now %s and the temperature feels like %s, with humidity in %s%%. The wind is in %s " +
                        "direction and %s Km/h",
                city, climate.location().country(), climate.current().condition().text(),
                climate.current().temp_c(), climate.current().temp_f(), climate.location().localtime(),
                climate.current().feelslike_c(), climate.current().humidity(), climate.current().wind_dir(),
                climate.current().wind_kph());
        return response;
    }


}
