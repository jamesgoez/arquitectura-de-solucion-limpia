package co.base.project.driven.adapter.rest.consumer.weatherapi.properties;

import lombok.Data;

@Data
public class WeatherAPIProperties {

    String url;
    String key;
    String days;
    String aqi;
    String alerts;
    String lang;
}
