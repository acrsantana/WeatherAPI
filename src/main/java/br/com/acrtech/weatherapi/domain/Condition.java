package br.com.acrtech.weatherapi.domain;

public record Condition(
        String text,
        String icon,
        int code
) {
}
