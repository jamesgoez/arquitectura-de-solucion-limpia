package co.base.project.driven.adapters.repository.notification.mappers.impl;

import co.base.project.driven.adapters.repository.notification.entities.NotificationEntity;
import co.base.project.driven.adapters.repository.notification.mappers.INotificationEntityMapper;
import co.base.project.usecase.notification.save.dto.SaveNotificationInputDTO;
import co.base.project.usecase.notification.save.dto.SaveNotificationOutputDTO;

import java.time.Instant;

public class NotificationEntityMapper implements INotificationEntityMapper {

    @Override
    public NotificationEntity toNotificationEntity(SaveNotificationInputDTO notificationInputDTO) {

        return NotificationEntity.builder()
                .buyerEmail(notificationInputDTO.getBuyerEmail().orElseThrow())
                .latitude(notificationInputDTO.getLatitude().orElseThrow())
                .longitude(notificationInputDTO.getLongitude().orElseThrow())
                .forecastCode(notificationInputDTO.getForecastCode())
                .forecastDescription(notificationInputDTO.getForecastDescription())
                .buyerNotification(notificationInputDTO.getBuyerNotification())
                .creationDate(Instant.now())
                .build();
    }

    @Override
    public SaveNotificationOutputDTO toNotificationOutputDTO(NotificationEntity notificationEntity) {

        return SaveNotificationOutputDTO.builder()
                .forecastCode(notificationEntity.getForecastCode())
                .forecastDescription(notificationEntity.getForecastDescription())
                .buyerNotification(notificationEntity.getBuyerNotification())
                .build();
    }
}
