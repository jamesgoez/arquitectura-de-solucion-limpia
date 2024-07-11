package co.base.project.model.notification.dto;

import lombok.Builder;
import lombok.Data;

import java.time.Instant;

@Data
@Builder(toBuilder = true)
public class NotificationInputDomainDTO {

    private Long id;
    private String buyerEmail;
    private double latitude;
    private double longitude;
    private Integer forecastCode;
    private String forecastDescription;
    private Boolean buyerNotification;
    private Instant creationDate;
}
