package co.base.project.configuration;

import co.base.project.driven.adapter.rest.consumer.weatherapi.configuration.WeatherAPIConsumer;
import co.base.project.driven.adapter.rest.consumer.weatherapi.properties.WeatherAPIProperties;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Slf4j
@Configuration
public class RestConsumerConfiguration {

    @Bean
    public WeatherAPIConsumer buildWeatherAPIConsumer(WeatherAPIProperties weatherAPIProperties) {
        return new WeatherAPIConsumer(weatherAPIProperties);
    }
}
