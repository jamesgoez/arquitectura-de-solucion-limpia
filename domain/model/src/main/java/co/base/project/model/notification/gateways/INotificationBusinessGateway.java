package co.base.project.model.notification.gateways;

import co.base.project.model.notification.dto.NotificationInputDomainDTO;
import co.base.project.model.notification.dto.NotificationOutputDomainDTO;
import co.base.project.model.transversal.gateways.IBusinessGateway;

public interface INotificationBusinessGateway extends IBusinessGateway<NotificationInputDomainDTO, NotificationOutputDomainDTO> {
}
