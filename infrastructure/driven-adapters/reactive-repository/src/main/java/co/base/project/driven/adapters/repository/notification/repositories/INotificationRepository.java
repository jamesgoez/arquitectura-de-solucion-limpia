package co.base.project.driven.adapters.repository.notification.repositories;

import co.base.project.driven.adapters.repository.notification.entities.NotificationEntity;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;

public interface INotificationRepository extends ReactiveCrudRepository<NotificationEntity, Long> {

    Flux<NotificationEntity> findAllByBuyerEmailAndBuyerNotification(String buyerEmail, Boolean buyerNotification);

}
