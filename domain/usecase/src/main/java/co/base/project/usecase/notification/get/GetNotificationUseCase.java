package co.base.project.usecase.notification.get;

import co.base.project.usecase.notification.gateways.persistence.INotificationServices;
import co.base.project.usecase.notification.get.dto.GetNotificationInputDTO;
import co.base.project.usecase.notification.get.dto.GetNotificationsOutputDTO;
import co.base.project.usecase.notification.get.exceptions.NotificationNoFoundException;
import co.base.project.usecase.notification.get.gateways.IGetNotificationUseCase;
import co.base.project.usecase.transversal.enums.ApplicationCodesEnum;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
@RequiredArgsConstructor
public class GetNotificationUseCase implements IGetNotificationUseCase {

    private final INotificationServices iNotificationServices;

    @Override
    public Mono<GetNotificationsOutputDTO> execute(Mono<GetNotificationInputDTO> inputUseCaseObject) {
        return inputUseCaseObject.map(getNotificationInputDTO -> iNotificationServices.getNotifications(getNotificationInputDTO))
                .switchIfEmpty(Mono.error(new NotificationNoFoundException(ApplicationCodesEnum.NOTIFICATION_NOT_FOUND)))
                .flatMap(Flux::collectList)
                .map(getNotificationList -> GetNotificationsOutputDTO.builder()
                        .notifications(getNotificationList)
                        .build());
    }
}
