package co.base.project.usecase.notification.get.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder(toBuilder = true)
public class GetNotificationsOutputDTO {
    private List<GetNotificationOutputDTO> notifications;

}
