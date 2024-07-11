package co.base.project.usecase.notification.save.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder(toBuilder = true)
public class SaveNotificationOutputDTO {

    private int forecastCode;
    private String forecastDescription;
    private Boolean buyerNotification;


}
