package co.base.project.usecase.notification.get.gateways;

import co.base.project.usecase.notification.get.dto.GetNotificationInputDTO;
import co.base.project.usecase.notification.get.dto.GetNotificationsOutputDTO;
import co.base.project.usecase.transversal.gateways.IUseCase;

public interface IGetNotificationUseCase extends IUseCase<GetNotificationInputDTO, GetNotificationsOutputDTO> {
}
