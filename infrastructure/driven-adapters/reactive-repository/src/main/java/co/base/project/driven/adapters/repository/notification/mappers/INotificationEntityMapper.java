package co.base.project.driven.adapters.repository.notification.mappers;

import co.base.project.driven.adapters.repository.notification.entities.NotificationEntity;
import co.base.project.usecase.notification.save.dto.SaveNotificationInputDTO;
import co.base.project.usecase.notification.save.dto.SaveNotificationOutputDTO;

public interface INotificationEntityMapper {

    NotificationEntity toNotificationEntity(SaveNotificationInputDTO notificationInputDTO);
    SaveNotificationOutputDTO toNotificationOutputDTO(NotificationEntity notificationEntity);
}
