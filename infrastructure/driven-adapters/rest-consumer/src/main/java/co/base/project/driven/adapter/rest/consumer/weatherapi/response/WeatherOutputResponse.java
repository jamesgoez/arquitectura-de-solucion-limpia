package co.base.project.driven.adapter.rest.consumer.weatherapi.response;

import co.base.project.driven.adapter.rest.consumer.weatherapi.response.dto.Current;
import lombok.Data;

@Data
public class WeatherOutputResponse {
    public Current current;
}
