package co.base.project.configuration.properties;

import co.base.project.driven.adapter.rest.consumer.weatherapi.properties.WeatherAPIProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties
@ConfigurationProperties(prefix = "weatherapi")
public class WeatherAPIPropertiesConfiguration  extends WeatherAPIProperties {
}
