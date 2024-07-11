package co.base.project.driven.adapters.repository.notification.mappers;

import co.base.project.driven.adapters.repository.notification.entities.NotificationEntity;
import co.base.project.usecase.notification.get.dto.GetNotificationOutputDTO;

public interface IGetNotificationEntityMapper {

    GetNotificationOutputDTO toNotificationOutputDTO(NotificationEntity notificationEntity);
}
