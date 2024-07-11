package co.base.project.usecase.weather.api.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder(toBuilder = true)
public class WeatherOutputDTO {

    private Integer forecastCode;
    private String forecastDescription;

}
