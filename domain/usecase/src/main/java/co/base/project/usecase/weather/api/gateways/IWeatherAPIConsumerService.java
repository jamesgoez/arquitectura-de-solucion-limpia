package co.base.project.usecase.weather.api.gateways;

import co.base.project.usecase.weather.api.dto.WeatherInputDTO;
import co.base.project.usecase.weather.api.dto.WeatherOutputDTO;
import reactor.core.publisher.Mono;

public interface IWeatherAPIConsumerService {

    Mono<WeatherOutputDTO> getWeather(WeatherInputDTO weatherInputDTO);
}
