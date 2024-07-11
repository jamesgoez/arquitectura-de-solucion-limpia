package co.base.project.business.notification;

import co.base.project.model.notification.dto.NotificationInputDomainDTO;
import co.base.project.model.notification.dto.NotificationOutputDomainDTO;
import co.base.project.model.notification.gateways.INotificationBusinessGateway;
import reactor.core.publisher.Mono;

public class NotificationBusiness implements INotificationBusinessGateway {

    @Override
    public Mono<NotificationOutputDomainDTO> executeBusinessRules(NotificationInputDomainDTO notificationInputDomainDTO) {
        return Mono.just(NotificationOutputDomainDTO.builder()
                .id(notificationInputDomainDTO.getId())
                .buyerEmail(notificationInputDomainDTO.getBuyerEmail())
                .latitude(notificationInputDomainDTO.getLatitude())
                .longitude(notificationInputDomainDTO.getLongitude())
                .forecastCode(notificationInputDomainDTO.getForecastCode())
                .forecastDescription(notificationInputDomainDTO.getForecastDescription())
                .buyerNotification(notificationInputDomainDTO.getBuyerNotification())
                .creationDate(notificationInputDomainDTO.getCreationDate())
                .build());
    }
}
