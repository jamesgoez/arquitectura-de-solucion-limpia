package co.base.project.driven.adapters.repository.notification.services;

import co.base.project.driven.adapters.repository.notification.mappers.IGetNotificationEntityMapper;
import co.base.project.driven.adapters.repository.notification.mappers.INotificationEntityMapper;
import co.base.project.driven.adapters.repository.notification.repositories.INotificationRepository;
import co.base.project.usecase.notification.gateways.persistence.INotificationServices;
import co.base.project.usecase.notification.get.dto.GetNotificationInputDTO;
import co.base.project.usecase.notification.get.dto.GetNotificationOutputDTO;
import co.base.project.usecase.notification.save.dto.SaveNotificationInputDTO;
import co.base.project.usecase.notification.save.dto.SaveNotificationOutputDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
@Repository
public class NotificationServices implements INotificationServices {



    private final INotificationRepository iNotificationRepository;
    private final INotificationEntityMapper iNotificationEntityMapper;
    private final IGetNotificationEntityMapper iGetNotificationEntityMapper;

    public NotificationServices(INotificationRepository iNotificationRepository, INotificationEntityMapper iNotificationEntityMapper, IGetNotificationEntityMapper iGetNotificationEntityMapper) {
        this.iNotificationRepository = iNotificationRepository;
        this.iNotificationEntityMapper = iNotificationEntityMapper;
        this.iGetNotificationEntityMapper = iGetNotificationEntityMapper;
    }

    @Override
    public Mono<SaveNotificationOutputDTO> save(SaveNotificationInputDTO notificationInputDTO) {
        return  Mono.just(iNotificationEntityMapper.toNotificationEntity(notificationInputDTO))
                .flatMap(notificationEntity -> iNotificationRepository.save(notificationEntity))
                .map(iNotificationEntityMapper::toNotificationOutputDTO);
    }

    @Override
    public Flux<GetNotificationOutputDTO> getNotifications(GetNotificationInputDTO getNotificationInputDTO) {
        return iNotificationRepository.findAllByBuyerEmailAndBuyerNotification(getNotificationInputDTO.getBuyerEmail().orElseThrow(), Boolean.TRUE)
                .map(iGetNotificationEntityMapper::toNotificationOutputDTO);
    }
}
