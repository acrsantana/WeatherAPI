package br.com.acrtech.weatherapi.domain;

public record Current(
        int last_updated_epoch,
        String last_updated,
        double temp_c,
        double temp_f,
        int is_day,
        Condition condition,
        double wind_mph,
        double wind_kph,
        int wind_degree,
        String wind_dir,
        double pressure_mb,
        double pressure_in,
        double precip_mm,
        double precip_in,
        int humidity,
        int cloud,
        double feelslike_c,
        double feelslike_f,
        double vis_km,
        double vis_miles,
        double uv,
        double gust_mph,
        double gust_kph
) {
}
