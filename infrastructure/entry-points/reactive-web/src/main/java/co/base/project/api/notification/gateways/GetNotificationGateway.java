package co.base.project.api.notification.gateways;

import co.base.project.api.transversal.helpers.ServerRequestToUseCaseInputObjectHelper;
import co.base.project.api.transversal.helpers.ServerResponseHelper;
import co.base.project.usecase.notification.get.dto.GetNotificationInputDTO;
import co.base.project.usecase.notification.get.dto.GetNotificationsOutputDTO;
import co.base.project.usecase.notification.get.gateways.IGetNotificationUseCase;
import co.base.project.usecase.transversal.gateways.AbstractUseCaseGateway;
import org.springframework.validation.Validator;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

public class GetNotificationGateway extends AbstractUseCaseGateway<ServerRequest, GetNotificationInputDTO, GetNotificationsOutputDTO, ServerResponse> {
    public GetNotificationGateway(
            Validator validator,
            IGetNotificationUseCase iGetNotificationUseCase,
            ServerResponseHelper<GetNotificationsOutputDTO> responseHelper,
            ServerRequestToUseCaseInputObjectHelper<GetNotificationInputDTO> useCaseInputObjectHelper) {
        super(GetNotificationInputDTO.class, validator, iGetNotificationUseCase, responseHelper, useCaseInputObjectHelper);
    }

    @Override
    protected Mono<GetNotificationInputDTO> buildUseCaseInputObject(ServerRequest serverRequest) {
        return Mono.justOrEmpty(GetNotificationInputDTO.builder()
                .buyerEmail(serverRequest.queryParam("buyerEmail").orElse(""))
                .build());
    }
}
