package co.base.project.driven.adapter.rest.consumer.weatherapi.services;

import co.base.project.driven.adapter.rest.consumer.weatherapi.configuration.WeatherAPIConsumer;
import co.base.project.driven.adapter.rest.consumer.weatherapi.exceptions.RestConsumerException;
import co.base.project.driven.adapter.rest.consumer.weatherapi.response.WeatherOutputResponse;
import co.base.project.usecase.transversal.enums.ApplicationCodesEnum;
import co.base.project.usecase.weather.api.dto.WeatherInputDTO;
import co.base.project.usecase.weather.api.dto.WeatherOutputDTO;
import co.base.project.usecase.weather.api.gateways.IWeatherAPIConsumerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class WeatherAPIConsumerService implements IWeatherAPIConsumerService {

    private final WeatherAPIConsumer weatherAPIConsumer;

    @Override
    public Mono<WeatherOutputDTO> getWeather(WeatherInputDTO weatherInputDTO) {
        return weatherAPIConsumer.getWebClient()
                .get()
                .uri(uriBuilder -> uriBuilder
                        .queryParam("q", String.valueOf(weatherInputDTO.getLatitude())
                                .concat(",").concat(String.valueOf(weatherInputDTO.getLongitude())))
                        .build())
                .retrieve()
                .bodyToMono(WeatherOutputResponse.class)
                .map(weatherOutputResponse -> WeatherOutputDTO.builder()
                        .forecastCode(weatherOutputResponse.getCurrent().getCondition().code)
                        .forecastDescription(weatherOutputResponse.getCurrent().getCondition().text)
                        .build())
                .onErrorMap(error -> new RestConsumerException(ApplicationCodesEnum.NO_SE_PUDO_CONSUMIR_SERVICIO_WEATHER, "datos de conexion invalidos "
                        .concat(error.getMessage())));
    }

}
