package br.com.acrtech.weatherapi.config;

import lombok.Data;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
@Data
public class PropertiesConfig {
    @Value("${weatherapi.key}")
    private String key;
    @Value("${weatherapi.url}")
    private String url;
    @Value("${weatherapi.app}")
    private String app;
    @Value("${weatherapi.host}")
    private String host;
}
