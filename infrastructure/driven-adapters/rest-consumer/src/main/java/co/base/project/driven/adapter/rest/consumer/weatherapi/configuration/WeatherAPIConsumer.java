package co.base.project.driven.adapter.rest.consumer.weatherapi.configuration;

import co.base.project.driven.adapter.rest.consumer.weatherapi.properties.WeatherAPIProperties;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.client.reactive.ClientHttpConnector;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.netty.http.client.HttpClient;

@RequiredArgsConstructor
public class WeatherAPIConsumer {

    private final WeatherAPIProperties weatherAPIProperties;

    public WebClient getWebClient() {
        return WebClient.builder()
                .baseUrl(weatherAPIProperties.getUrl()
                        .concat("key=").concat(weatherAPIProperties.getKey())
                        .concat("&days=").concat(weatherAPIProperties.getDays())
                        .concat("&aqi=").concat(weatherAPIProperties.getAqi())
                        .concat("&alerts=").concat(weatherAPIProperties.getAlerts())
                        .concat("&lang=").concat(weatherAPIProperties.getLang())
                )

                .defaultHeader(HttpHeaders.CONTENT_TYPE, "application/json")
                .clientConnector(getClientHttpConnector())
                .build();
    }

    private ClientHttpConnector getClientHttpConnector() {
        return new ReactorClientHttpConnector(HttpClient.create()
                .compress(true)
                .keepAlive(true)
        );
    }
}

