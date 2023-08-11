package br.com.acrtech.weatherapi.domain;

public record Root(
        Location location,
        Current current
) {
}
