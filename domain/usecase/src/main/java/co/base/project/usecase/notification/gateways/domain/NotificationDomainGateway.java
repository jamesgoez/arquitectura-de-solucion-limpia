package co.base.project.usecase.notification.gateways.domain;

import co.base.project.model.notification.dto.NotificationInputDomainDTO;
import co.base.project.model.notification.dto.NotificationOutputDomainDTO;
import co.base.project.model.notification.gateways.INotificationBusinessGateway;
import co.base.project.model.transversal.gateways.AbstractDomainGateway;
import co.base.project.usecase.notification.save.dto.SaveNotificationOutputDTO;
import reactor.core.publisher.Mono;

public class NotificationDomainGateway extends AbstractDomainGateway<SaveNotificationOutputDTO, NotificationInputDomainDTO, NotificationOutputDomainDTO, SaveNotificationOutputDTO> {

    private final INotificationBusinessGateway iNotificationBusinessGateway;

    public NotificationDomainGateway(INotificationBusinessGateway iNotificationBusinessGateway) {
        this.iNotificationBusinessGateway = iNotificationBusinessGateway;
    }

    @Override
    protected NotificationInputDomainDTO buildDomainInputObject(SaveNotificationOutputDTO notificationOutputDTO) {
        return NotificationInputDomainDTO.builder()
                .forecastCode(notificationOutputDTO.getForecastCode())
                .forecastDescription(notificationOutputDTO.getForecastDescription())
                .buyerNotification(notificationOutputDTO.getBuyerNotification())
                .build();
    }

    @Override
    protected Mono<NotificationOutputDomainDTO> executeBusinessRules(NotificationInputDomainDTO domainInputObject) {
        return iNotificationBusinessGateway.executeBusinessRules(domainInputObject);
    }

    @Override
    protected Mono<SaveNotificationOutputDTO> buildOutputObject(Mono<NotificationOutputDomainDTO> domainOutputObject) {
        return domainOutputObject
                .map(notificationOutputDomainDTO -> SaveNotificationOutputDTO.builder()
                        .forecastCode(notificationOutputDomainDTO.getForecastCode())
                        .forecastDescription(notificationOutputDomainDTO.getForecastDescription())
                        .buyerNotification(notificationOutputDomainDTO.getBuyerNotification())
                        .build());
    }
}
