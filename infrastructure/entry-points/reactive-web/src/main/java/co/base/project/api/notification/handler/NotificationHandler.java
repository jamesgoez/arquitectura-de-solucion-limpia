package co.base.project.api.notification.handler;

import co.base.project.api.notification.gateways.GetNotificationGateway;
import co.base.project.api.notification.gateways.SaveNotificationGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class NotificationHandler {

    private final SaveNotificationGateway saveNotificationGateway;
    private final GetNotificationGateway getNotificationGateway;

    public Mono<ServerResponse> saveNotification(ServerRequest serverRequest) {
        return saveNotificationGateway.execute(serverRequest);
    }

    public Mono<ServerResponse> getNotifications(ServerRequest serverRequest) {
        return getNotificationGateway.execute(serverRequest);
    }
}
