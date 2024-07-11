package co.base.project.driven.adapters.repository.notification.mappers.impl;

import co.base.project.driven.adapters.repository.notification.entities.NotificationEntity;
import co.base.project.driven.adapters.repository.notification.mappers.IGetNotificationEntityMapper;
import co.base.project.usecase.notification.get.dto.GetNotificationOutputDTO;

import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class GetNotificationEntityMapper implements IGetNotificationEntityMapper {
    @Override
    public GetNotificationOutputDTO toNotificationOutputDTO(NotificationEntity notificationEntity) {
        DateTimeFormatter formatter  = DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm")
                .withZone(ZoneId.systemDefault());
        return GetNotificationOutputDTO.builder()
                .latitude(notificationEntity.getLatitude())
                .longitude(notificationEntity.getLongitude())
                .forecastDescription(notificationEntity.getForecastDescription())
                .notificationSendDate(formatter.format(notificationEntity.getCreationDate()))
                .build();
    }
}
