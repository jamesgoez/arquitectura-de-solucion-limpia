package co.base.project.usecase.weather.api.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder(toBuilder = true)
public class WeatherInputDTO {
    private double latitude;
    private double longitude;
}
