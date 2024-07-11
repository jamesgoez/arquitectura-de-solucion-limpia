package co.base.project.usecase.notification.get.dto;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder(toBuilder = true)
public class GetNotificationOutputDTO {
    private double latitude;
    private double longitude;
    private String forecastDescription;
    private String notificationSendDate;
}
