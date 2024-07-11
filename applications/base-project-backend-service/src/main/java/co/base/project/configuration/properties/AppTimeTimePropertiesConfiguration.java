package co.base.project.configuration.properties;

import co.base.project.driven.adapters.repository.task.properties.AppTimeProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties
@ConfigurationProperties(prefix = "app.time")
public class AppTimeTimePropertiesConfiguration extends AppTimeProperties {
}
