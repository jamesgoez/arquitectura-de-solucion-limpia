package co.base.project.usecase.notification.gateways.persistence;

import co.base.project.usecase.notification.get.dto.GetNotificationInputDTO;
import co.base.project.usecase.notification.get.dto.GetNotificationOutputDTO;
import co.base.project.usecase.notification.save.dto.SaveNotificationInputDTO;
import co.base.project.usecase.notification.save.dto.SaveNotificationOutputDTO;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface INotificationServices {
    Mono<SaveNotificationOutputDTO> save(SaveNotificationInputDTO notificationInputDTO);

    Flux<GetNotificationOutputDTO> getNotifications(GetNotificationInputDTO getNotificationInputDTO);
}
